package com.alonsocorp.aleyumy.Controlador;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alonsocorp.aleyumy.DTO.ProductoDTO;
import com.alonsocorp.aleyumy.modelo.DetalleFactura;
import com.alonsocorp.aleyumy.modelo.Factura;
import com.alonsocorp.aleyumy.modelo.Usuarios;
import com.alonsocorp.aleyumy.repository.DetalleFacturaRepository;
import com.alonsocorp.aleyumy.repository.FacturaRepository;
import com.alonsocorp.aleyumy.repository.UsuariosRepository;
import com.alonsocorp.aleyumy.servicio.MetodoPagoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;

@Controller
public class CarritoControlador {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Autowired
    private MetodoPagoService metodoPagoService;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @PostMapping("/realizarCompra")
    @Transactional
    public String realizarCompra(@RequestParam String nombres,
                             @RequestParam String apellidos,
                             @RequestParam String correo,
                             @RequestParam String telefono,
                             @RequestParam String direccion,
                             @RequestParam String ciudad,
                             @RequestParam String codigoPostal,
                             @RequestParam String pago,
                             @RequestParam String carritoJson,
                             RedirectAttributes redirectAttrs) throws Exception {

    int idPago = metodoPagoService.obtenerIdPorTipo(pago);

    // Buscar cliente por correo
    Usuarios cliente = usuariosRepository.findByCorreo(correo);
    if (cliente == null) {
        redirectAttrs.addFlashAttribute("error", "El correo no está registrado en clientes.");
        return "redirect:/pedidos";
    }

    // Crear factura con ID_CLIENTE
    Factura factura = new Factura();
    factura.setIdCliente(cliente.getId());
    factura.setIdPago(idPago);
    factura.setFecha(LocalDate.now());
    factura = facturaRepository.save(factura);

    ObjectMapper mapper = new ObjectMapper();
    System.out.println("Contenido de carritoJson: " + carritoJson);
    List<ProductoDTO> productos = mapper.readValue(carritoJson, new TypeReference<List<ProductoDTO>>() {});
    for (ProductoDTO p : productos) {
    try {
        System.out.println("Insertando detalle: ID=" + p.getId() +
                           ", Cant=" + p.getCantidad() +
                           ", Precio=" + p.getPrecio());

        DetalleFactura detalle = new DetalleFactura();
        detalle.setNFac(factura.getnFac());
        detalle.setIdProducto(p.getId());
        detalle.setCantidad(p.getCantidad());
        detalle.setPrecioUnitario(p.getPrecio());
        detalleFacturaRepository.save(detalle);

    } catch (Exception e) {
        e.printStackTrace(); 
    }
}

    redirectAttrs.addFlashAttribute("mensaje", "Compra realizada con éxito :D");
        return "redirect:/pedidos";
    }

}