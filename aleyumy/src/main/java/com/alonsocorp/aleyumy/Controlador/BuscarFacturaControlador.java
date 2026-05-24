package com.alonsocorp.aleyumy.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alonsocorp.aleyumy.DTO.BuscarFacturaDTO;
import com.alonsocorp.aleyumy.servicio.BuscarFacturaServicio;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BuscarFacturaControlador {
    @Autowired
    private BuscarFacturaServicio buscarfacserv;

    @GetMapping("/facturas/{nfac}")
    public List<BuscarFacturaDTO> buscarFac(@PathVariable String nfac){
        return buscarfacserv.buscarFac(nfac);
    }
}
