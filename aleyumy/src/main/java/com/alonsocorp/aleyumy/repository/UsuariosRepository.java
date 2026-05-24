package com.alonsocorp.aleyumy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alonsocorp.aleyumy.modelo.Usuarios;


public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    Usuarios findByCorreo(String correo);

    @Query(value = "CALL obtenerClientes()", nativeQuery = true)
    List<Usuarios> obtenerUsuarios();

    Usuarios findByTokenLogin(String token);

    Usuarios findByTokenRecuperar(String token);

}
