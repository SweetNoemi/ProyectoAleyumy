package com.alonsocorp.aleyumy.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alonsocorp.aleyumy.modelo.Postulacion;
import com.alonsocorp.aleyumy.DTO.PostulacionDTO;
import com.alonsocorp.aleyumy.repository.PostulacionRepository;

@Service
public class PostulacionServicio {

    @Autowired
    PostulacionRepository post_res;

    public List<PostulacionDTO> obtenerPostulantes() {
        return post_res.obtenerPostulantes();
    }

    public Postulacion guardar(Postulacion postulacion) {
        return post_res.save(postulacion);
    }

    public List<Postulacion> listar(){
        return post_res.findAll();
    }

    public Postulacion buscar(int id){
        return post_res.findById(id).orElse(null);
    }

    public void eliminar(int id){
        post_res.deleteById(id);
    }
}
