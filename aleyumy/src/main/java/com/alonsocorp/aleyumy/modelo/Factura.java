package com.alonsocorp.aleyumy.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "FACTURA")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "N_FAC")
    private Integer nFac;

    @Column(name = "FECHA_FAC")
    private LocalDate fecha; 

    @Column(name = "ID_CLIENTE")
    private Integer idCliente;

    @Column(name = "ID_PAGO")
    private Integer idPago;

    public Factura() {}

    public Factura(Integer nFac, LocalDate fecha, Integer idCliente, Integer idPago) {
        this.nFac = nFac;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idPago = idPago;
    }

    public Integer getnFac() {
        return nFac;
    }

    public void setnFac(Integer nFac) {
        this.nFac = nFac;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }
    
}
