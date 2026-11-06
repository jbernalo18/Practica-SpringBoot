package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.model.Conductor;

import java.util.List;

public interface ConductorService{
    List<Conductor> findAll();
    Conductor findById(String id);
    Conductor save(Conductor conductor);
    Conductor update(String id, Conductor conductor);
    void deleteById(String id);
    List<Conductor> findByLicencia(String licencia);
}
