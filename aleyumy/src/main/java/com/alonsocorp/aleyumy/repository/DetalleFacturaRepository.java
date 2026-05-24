package com.alonsocorp.aleyumy.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alonsocorp.aleyumy.modelo.DetalleFactura;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {
    @Query("SELECT d FROM DetalleFactura d WHERE d.nFac = :nFac")
    List<DetalleFactura> buscarPorFactura(@Param("nFac") Integer nFac);
}
