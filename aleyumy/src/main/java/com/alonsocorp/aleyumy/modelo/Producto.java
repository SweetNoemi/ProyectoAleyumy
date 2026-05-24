package com.alonsocorp.aleyumy.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODUCTO")
public class Producto {
    @Id
    @Column(name="ID_PRODUCTO")
    Integer idProducto;
    @Column(name="NOM_PRODUCTO")
    String nomProducto;

    public Producto() {
    }

    public Producto(Integer idProducto, String nomProducto) {
        this.idProducto = idProducto;
        this.nomProducto = nomProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

}
