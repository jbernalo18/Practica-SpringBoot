package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.model.Conductor;
import com.interrapidisimo.sistema_logistico.model.Envio;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ConductorServiceMemoryImp implements ConductorService{
    private final List<Conductor> conductores = new ArrayList<>();

    public ConductorServiceMemoryImp(){
        conductores.add (new Conductor(UUID.randomUUID().toString(),"Camila","Vargas","1002342","3006789562","1Q2W3E4R"));
        conductores.add (new Conductor(UUID.randomUUID().toString(), "Andrés", "Restrepo", "1017654321", "3012345678", "2W3E4R5T"));
        conductores.add (new Conductor(UUID.randomUUID().toString(), "Laura", "Gómez", "1036789012", "3105558743", "3E4R5T6Y"));
        conductores.add (new Conductor(UUID.randomUUID().toString(), "Julián", "Ospina", "98765432", "3157894561", "4R5T6Y7U"));
        conductores.add (new Conductor(UUID.randomUUID().toString(), "Valentina", "Cardona", "1020456789", "3201234567", "5T6Y7U8I"));
        conductores.add (new Conductor(UUID.randomUUID().toString(), "Sebastián", "Mejía", "71234567", "3043216549", "6Y7U8I9O"));
        conductores.add (new Conductor(UUID.randomUUID().toString(), "Daniela", "Zapata", "1152468013", "3186547210", "7U8I9O0P"));
    }

    @Override
    public List<Conductor> findAll() {
        return new ArrayList<>(conductores);
    }

    @Override
    public Conductor findById(String id) {
        Optional<Conductor> conductor = conductores.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
        return conductor.orElse(null);
    }

    @Override
    public Conductor save(Conductor conductor) {
        if(conductor.getId()==null || conductor.getId().isEmpty()){
            conductor.setId(UUID.randomUUID().toString());
        }
        conductores.add(conductor);
        return conductor;
    }

    @Override
    public Conductor update(String id, Conductor conductorAct) {
        for(int i=0;i<conductores.size();i++){
            if(conductores.get(i).getId().equals(id)){
                conductorAct.setId(id);
                conductores.set(i,conductorAct);
                return conductorAct;
            }
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
    conductores.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public List<Conductor> findByLicencia(String licencia) {
        return conductores.stream()
                .filter(e -> e.getLicencia().equalsIgnoreCase(licencia))
                .toList();
    }


}
