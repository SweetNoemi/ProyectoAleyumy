package com.alonsocorp.aleyumy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alonsocorp.aleyumy.modelo.MetodoPago;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {
    MetodoPago findByTipoPago(String tipoPago);
}
