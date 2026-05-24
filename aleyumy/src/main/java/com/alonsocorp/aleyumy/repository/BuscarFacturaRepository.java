package com.alonsocorp.aleyumy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alonsocorp.aleyumy.DTO.BuscarFacturaDTO;
import com.alonsocorp.aleyumy.modelo.Factura;

@Repository
public interface BuscarFacturaRepository extends JpaRepository<Factura, Integer> {
    @Query(value="CALL buscarFac(:nfac)", nativeQuery=true)
    List<BuscarFacturaDTO> buscarFac(@Param("nfac") String nfac);
}
