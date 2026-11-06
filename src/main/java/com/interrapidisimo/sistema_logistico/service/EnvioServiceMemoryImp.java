package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.model.Envio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnvioServiceMemoryImp implements EnvioService{

    private final List<Envio> envios = new ArrayList<>();

    public EnvioServiceMemoryImp(){
        envios.add(new Envio(UUID.randomUUID().toString(),"cliente 1","Medellin","EN DESPACHO",20.23));
        envios.add(new Envio(UUID.randomUUID().toString(),"cliente 2","Bucaramanga","EN DISTRIBUCION",8.23));
        envios.add(new Envio(UUID.randomUUID().toString(),"cliente 3","Bogota","EN BODEGA",50.23));
        envios.add(new Envio(UUID.randomUUID().toString(),"cliente 4","Cartagena","EN DESPACHO",14.23));
    }

    @Override
    public List<Envio> findAll() {
        return new ArrayList<>(envios);
    }

    @Override
    public Envio findById(String id) {
        Optional<Envio> envio = envios.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
        return envio.orElse(null);
    }


    @Override
    public Envio save(Envio envio) {
        if(envio.getId() == null || envio.getId().isEmpty()){
            envio.setId(UUID.randomUUID().toString());
        }
        envios.add(envio);
        return envio;
    }

    @Override
    public Envio update(String id, Envio envioActualizado) {
        for(int i = 0; i < envios.size();i++){
            if(envios.get(i).getId().equals(id)){
                envioActualizado.setId(id);
                envios.set(i, envioActualizado);
                return envioActualizado;
            }
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        envios.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public List<Envio> findByEstado(String estado) {
        return envios.stream()
                .filter(e -> e.getEstado().equalsIgnoreCase(estado))
                .toList();
    }
}
