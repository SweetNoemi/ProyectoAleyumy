package com.alonsocorp.aleyumy.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPLEADOS")
public class Empleado implements Serializable{
    
    @Id
    @Column(name="EMP_ID")
    private String id;
    @Column(name="EMP_NOM")
    private String nombre;
    @Column(name="EMP_APE")
    private String apellido;
    @Column(name="EMP_DNI")
    private String dni;
    @Column(name="EMP_TEL")
    private String telefono;
    @Column(name="EMP_COR")
    private String correo;
    @Column(name="EMP_DIR")
    private String dirrecion;

    public Empleado() {
    }

    public Empleado(String id, String nombre, String apellido, 
    String dni, String telefono, String correo,
            String dirrecion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
        this.dirrecion = dirrecion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDirrecion() {
        return dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }

    
    
    
}
