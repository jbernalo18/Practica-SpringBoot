package com.clase.practica_springboot.service;

import com.clase.practica_springboot.model.Envio;

import java.util.*;

public interface EnvioService {

    List<Envio> findAll();
    Envio findById(String id);
    Envio save(Envio envio);
    Envio update(String id, Envio envioActualizado);
    void deletebyId(String id);
    List<Envio> findByEstado(String estado);
}
