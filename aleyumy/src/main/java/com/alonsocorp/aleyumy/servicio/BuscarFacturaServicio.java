package com.alonsocorp.aleyumy.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alonsocorp.aleyumy.DTO.BuscarFacturaDTO;
import com.alonsocorp.aleyumy.repository.BuscarFacturaRepository;

@Service
public class BuscarFacturaServicio {
    @Autowired 
    private BuscarFacturaRepository buscarfacrepo;

    public List<BuscarFacturaDTO> buscarFac(String nfac){
        return buscarfacrepo.buscarFac(nfac);
    }
}
