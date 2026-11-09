package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.model.Conductor;

import java.util.List;

public interface ConductorService{
    List<Conductor> findAll();
    Conductor findById(Long id);
    Conductor save(Conductor conductor);
    Conductor update(Long id, Conductor conductor);
    void deleteById(Long id);
    List<Conductor> findByLicencia(String licencia);
}
