package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.model.ConductorEnvio;
import com.interrapidisimo.sistema_logistico.model.Envio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EnvioService {
    Page<Envio> findAll(Pageable pageable);
    Envio findById(Long id);
    Envio save(Envio envio);
    Envio update(Long id, Envio envio);
    void deleteById(Long id);
    Page<Envio> findByEstado(String estado, Pageable pageable);
}
