package com.alonsocorp.aleyumy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alonsocorp.aleyumy.modelo.Empleado;
import com.alonsocorp.aleyumy.DTO.EmpleadoDTO;

public interface EmpleadosRepository extends JpaRepository<Empleado, String> {
    @Query(value="SELECT e.EMP_ID as id, e.EMP_NOM as nombre, e.EMP_APE as apellido, e.EMP_DNI as dni, e.EMP_TEL as telefono, e.EMP_COR as correo FROM EMPLEADOS e order by e.EMP_ID ASC", nativeQuery=true)
    List<EmpleadoDTO> obtenerEmpleados();
}
