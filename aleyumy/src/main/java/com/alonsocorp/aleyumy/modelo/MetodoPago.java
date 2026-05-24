package com.alonsocorp.aleyumy.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "METODO_PAGO")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGO")
    private Integer idPago;

    @Column(name = "TIPO_PAGO")
    private String tipoPago;

    // Getters y Setters
    public Integer getIdPago() { return idPago; }
    public void setIdPago(Integer idPago) { this.idPago = idPago; }

    public String getTipoPago() { return tipoPago; }
    public void setTipoPago(String tipoPago) { this.tipoPago = tipoPago; }
}