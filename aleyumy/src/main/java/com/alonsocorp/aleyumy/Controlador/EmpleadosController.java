package com.alonsocorp.aleyumy.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alonsocorp.aleyumy.modelo.Empleado;
import com.alonsocorp.aleyumy.servicio.EmpleadosSercicio;

@Controller
public class EmpleadosController {
    
    @Autowired
    EmpleadosSercicio servicio;

    @GetMapping("/tablaEmpleados")
    public String mostrarTabla(Model modelo) {
        modelo.addAttribute("lista_Empleados", servicio.obtenerEmpleados());
        return "tablaEmpleados";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Empleado empleado) {
        servicio.guardar(empleado);
        return "redirect:/tablaEmpleados";
    }
    

    @GetMapping("/editarE/{id}")
    public String editar(@PathVariable("id") String id, Model modelo) {
        Empleado empleado = servicio.buscarPorID(id);
        modelo.addAttribute("lista_Empleados", empleado);
        return "edicionEmpleados";
    }
    
    @GetMapping("/eliminarE/{id}")
    public String eliminar(@PathVariable("id") String id) {
        servicio.eliminar(id);
        return "redirect:/tablaEmpleados";
    }
    

}
