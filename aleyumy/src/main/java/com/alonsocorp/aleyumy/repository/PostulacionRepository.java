package com.alonsocorp.aleyumy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alonsocorp.aleyumy.DTO.PostulacionDTO;
import com.alonsocorp.aleyumy.modelo.Postulacion;

public interface PostulacionRepository extends JpaRepository<Postulacion, Integer> {
    @Query(value = "CALL obtenerPostulantes()", nativeQuery = true)
    List<PostulacionDTO> obtenerPostulantes();
}
