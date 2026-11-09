package com.interrapidisimo.sistema_logistico.repository;

import com.interrapidisimo.sistema_logistico.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ConductorRepository extends JpaRepository<Conductor,Long> {
    List<Conductor> findByLicenciaIgnoreCase(String licencia);
    List<Conductor> findByNombreContaining(String nombre);
}
