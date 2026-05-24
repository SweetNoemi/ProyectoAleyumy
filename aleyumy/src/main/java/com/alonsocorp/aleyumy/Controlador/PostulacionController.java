package com.alonsocorp.aleyumy.Controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alonsocorp.aleyumy.modelo.Postulacion;
import com.alonsocorp.aleyumy.servicio.PostulacionServicio;

@Controller
public class PostulacionController {
    
    @Autowired
    PostulacionServicio servicio;

    // Mostrar formulario de postulación
    @GetMapping("/trabajo")
    public String mostrarFormulario(Model modelo){
        modelo.addAttribute("postulacion", new Postulacion());
        return "trabaja";  // tu formulario principal
    }

    // Guardar nueva postulación
    @PostMapping("/agregarPostulacion")
    public String agregar(@ModelAttribute Postulacion postulacion, Model modelo){
        servicio.guardar(postulacion);
        modelo.addAttribute("postulacion", new Postulacion());
        return "redirect:/trabajo";
    }

    // Mostrar tabla de postulaciones
    @GetMapping("/tablaPostulacion")
    public String mostrarTabla(Model modelo){
        modelo.addAttribute("lista_Postulacion", servicio.obtenerPostulantes());
        return "empleado";
    }

    // Eliminar postulante
    @GetMapping("/eliminarPostulacion/{id}")
    public String eliminar(@PathVariable int id){
        servicio.eliminar(id);
        return "redirect:/empleado";
    }


    @PostMapping("/buscarPostulante")
    public String buscar(@RequestParam int id, Model modelo){
        Postulacion p = servicio.buscar(id);
        List<Postulacion> resultado = new ArrayList<>();
    
        if(p != null) {
            resultado.add(p);
        }else{
            modelo.addAttribute("mensaje", "Este código no existe.");
        }

        modelo.addAttribute("lista_Postulacion", resultado);
        return "empleado";
    }
}
