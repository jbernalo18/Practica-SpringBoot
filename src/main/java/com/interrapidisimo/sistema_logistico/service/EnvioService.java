package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.model.ConductorEnvio;
import com.interrapidisimo.sistema_logistico.model.Envio;

import java.util.List;

public interface EnvioService {
    List<Envio> findAll();
    Envio findById(Long id);
    Envio save(Envio envio);
    Envio update(Long id, Envio envio);
    void deleteById(Long id);
    List<Envio> findByEstado(String estado);
}
