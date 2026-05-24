package com.alonsocorp.aleyumy.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CLIENTES")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @Column(name="CORREO", length = 50, nullable = false, unique = true)
    private String correo;

    @Column(name="CONTRASENA", length = 255, nullable = false)
    private String contrasena;

    @Column(name="NOMBRE", length = 50, nullable = false)
    private String nombre;

    @Column(name="APELLIDO", length = 50, nullable = false)
    private String apellido;

    @Column(name="TOKEN_LOGIN")
    private String tokenLogin;

    @Column(name="TOKEN_LOGIN_EXPIRA")
    private LocalDateTime tokenLoginExpira;

    @Column(name="TOKEN_RECUPERAR")
    private String tokenRecuperar;

    @Column(name="TOKEN_RECUPERAR_EXPIRA")
    private LocalDateTime tokenRecuperarExpira;

    // Constructor vacío 
    public Usuarios() {}

    // Constructor 
    public Usuarios(String correo, String contrasena, String nombre, String apellido) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public String getTokenLogin() {
        return tokenLogin;
    }

    public void setTokenLogin(String tokenLogin) {
        this.tokenLogin = tokenLogin;
    }

    public LocalDateTime getTokenLoginExpira() {
        return tokenLoginExpira;
    }

    public void setTokenLoginExpira(LocalDateTime tokenLoginExpira) {
        this.tokenLoginExpira = tokenLoginExpira;
    }

    public String getTokenRecuperar() {
        return tokenRecuperar;
    }

    public void setTokenRecuperar(String tokenRecuperar) {
        this.tokenRecuperar = tokenRecuperar;
    }

    public LocalDateTime getTokenRecuperarExpira() {
        return tokenRecuperarExpira;
    }

    public void setTokenRecuperarExpira(LocalDateTime tokenRecuperarExpira) {
        this.tokenRecuperarExpira = tokenRecuperarExpira;
    }


}
