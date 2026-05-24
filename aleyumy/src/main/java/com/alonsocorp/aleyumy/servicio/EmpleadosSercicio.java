package com.alonsocorp.aleyumy.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alonsocorp.aleyumy.DTO.EmpleadoDTO;
import com.alonsocorp.aleyumy.modelo.Empleado;
import com.alonsocorp.aleyumy.repository.EmpleadosRepository;

@Service
public class EmpleadosSercicio {
    
    @Autowired
    EmpleadosRepository empleados;

    
    public List<EmpleadoDTO> obtenerEmpleados(){
        return empleados.obtenerEmpleados();
    }
    
    public List<Empleado> listarTodos(){
        return empleados.findAll();
    }

    public Empleado buscarPorID(String codigo){
        return empleados.findById(codigo).orElse(null);
    }

    public Empleado guardar(Empleado empleado){
        return empleados.save(empleado);
    }

    public void eliminar(String id){
        empleados.deleteById(id);
    }

}
