package com.alonsocorp.aleyumy.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alonsocorp.aleyumy.modelo.MetodoPago;
import com.alonsocorp.aleyumy.repository.MetodoPagoRepository;

@Service
public class MetodoPagoService {
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public int obtenerIdPorTipo(String tipoPago) {
        MetodoPago metodo = metodoPagoRepository.findByTipoPago(tipoPago);
        if (metodo == null) {
            metodo = new MetodoPago();
            metodo.setTipoPago(tipoPago);
            metodo = metodoPagoRepository.save(metodo);
        }
        return metodo.getIdPago();
    }
}
