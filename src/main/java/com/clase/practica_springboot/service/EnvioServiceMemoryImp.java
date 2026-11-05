package com.clase.practica_springboot.service;

import com.clase.practica_springboot.model.Envio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnvioServiceMemoryImp implements EnvioService{

    private final List<Envio> envios = new ArrayList<>(); // base de satos ene memoria

    public EnvioServiceMemoryImp(){
        envios.add(new Envio(UUID.randomUUID().toString(),"Juliana","Bello","EN PROCESO",20));
        envios.add(new Envio(UUID.randomUUID().toString(), "Carlos", "Medellín", "ENTREGADO", 15));
        envios.add(new Envio(UUID.randomUUID().toString(), "Andrés", "Envigado", "EN RUTA", 8));
        envios.add(new Envio(UUID.randomUUID().toString(), "Camila", "Itagüí", "PENDIENTE", 32));
        envios.add(new Envio(UUID.randomUUID().toString(), "Santiago", "Sabaneta", "EN PROCESO", 12));
        envios.add(new Envio(UUID.randomUUID().toString(), "Mariana", "Copacabana", "CANCELADO", 5));
        envios.add(new Envio(UUID.randomUUID().toString(), "Mateo", "Girardota", "ENTREGADO", 45));
    }

    @Override
    public List<Envio> findAll() {
        return new ArrayList<>(envios);
    }

    @Override
    public Envio findById(String id) {
        Optional<Envio> envio = envios.stream()
                .filter( e -> e.getId().equals(id))
                .findFirst();

        return envio.orElse(null);
    }

    @Override
    public Envio save(Envio envio) {
        envios.add(envio);
        return envio;
    }

    @Override
    public Envio update(String id, Envio envioActualizado) {
        return null;
    }

    @Override
    public void deletebyId(String id) {

    }

    @Override
    public List<Envio> findByEstado(String estado) {
        return List.of();
    }
}
