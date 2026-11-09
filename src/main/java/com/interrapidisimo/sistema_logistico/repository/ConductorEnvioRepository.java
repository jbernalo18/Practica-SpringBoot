package com.interrapidisimo.sistema_logistico.repository;


import com.interrapidisimo.sistema_logistico.model.ConductorEnvio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ConductorEnvioRepository extends JpaRepository<ConductorEnvio,Long> {
    List<ConductorEnvio> findByEnvio_Id(Long id);



}
