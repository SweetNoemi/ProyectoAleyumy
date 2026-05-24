package com.alonsocorp.aleyumy.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="POSTULACION")
public class Postulacion implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_POSTULANTE")
    private Integer id;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="APELLIDO")
    private String apellido;
    @Column(name="DNI_PASAPORTE")
    private String dni;
    @Column(name="TELEFONO")
    private String telefono;
    @Column(name = "CORREO_POSTULACION")
    private String correo;
    @Column(name = "DIRECCION")
    private String direccion;

    // Constructor vacío
    public Postulacion() {}

    // Constructor con parámetros
    public Postulacion(String nombre, String apellido, String dni,
            String telefono, String correo, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}

