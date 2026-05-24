package com.alonsocorp.aleyumy.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DETALLE_FACTURA")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DETALLE")
    private Integer idDetalle;

    @Column(name = "N_FAC")
    private Integer nFac;   // FK hacia Factura

    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;  // FK hacia Producto

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "PRECIO_UNITARIO")
    private Double precioUnitario;

    public DetalleFactura() {}

    public DetalleFactura(Integer nFac, Integer idProducto, Integer cantidad, Double precioUnitario) {
        this.nFac = nFac;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // Getters y Setters
    public Integer getIdDetalle() { return idDetalle; }
    public void setIdDetalle(Integer idDetalle) { this.idDetalle = idDetalle; }

    public Integer getNFac() { return nFac; }
    public void setNFac(Integer nFac) { this.nFac = nFac; }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }
}

