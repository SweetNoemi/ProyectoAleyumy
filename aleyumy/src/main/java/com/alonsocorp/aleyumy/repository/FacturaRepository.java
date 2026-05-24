package com.alonsocorp.aleyumy.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alonsocorp.aleyumy.modelo.Factura;


@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    Factura findByIdCliente(Integer idCliente);
}