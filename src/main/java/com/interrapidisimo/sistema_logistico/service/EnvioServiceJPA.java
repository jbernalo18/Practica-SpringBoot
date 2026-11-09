package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.model.Envio;
import com.interrapidisimo.sistema_logistico.repository.EnvioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnvioServiceJPA implements EnvioService{

    private final EnvioRepository envioRepository;
    @Autowired
    public EnvioServiceJPA(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    @Override
    public List<Envio> findAll() {
        return  envioRepository.findAll();
    }

    @Override
    public Envio findById(Long id) {
        return envioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Envio no encontrado con id " + id));
    }

    @Override
    public Envio save(Envio envio) {
        double costo= calculateCostoEnvio(envio.getPesoKg(), envio.getDestino());
        envio.setCosto(costo);
        if(envio.getEstado()==null){
            envio.setEstado("PENDIENTE");
        }
        if(envio.getPesoKg()>500){
            throw new RuntimeException("El envio no puede pesar mas de 500Kg");
        }
        return envioRepository.save(envio);
    }


    @Override
    @Transactional
    public Envio update(Long id, Envio envioActualizado) {
        Envio existente = envioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Envio no encontrado con id: " + id));

        if ("ENTREGADO".equals(existente.getEstado())) {
            throw new RuntimeException("No se puede actualizar un envio que ya fue entregado");
        }

        if (envioActualizado.getEstado() != null
                && !envioActualizado.getEstado().equals(existente.getEstado())) {
            validarTransaccionEstado(existente.getEstado(), envioActualizado.getEstado());
            existente.setEstado(envioActualizado.getEstado());
        }

        if (cambiarPesoODestino(existente, envioActualizado)) {
            if (envioActualizado.getPesoKg() > 500) {
                throw new RuntimeException("El envio no puede pesar mas de 500Kg");
            }
            existente.setPesoKg(envioActualizado.getPesoKg());
            existente.setDestino(envioActualizado.getDestino());
            existente.setCosto(calculateCostoEnvio(existente.getPesoKg(), existente.getDestino()));
        }

        return envioRepository.save(existente);
    }

    @Override
    public void deleteById(Long id) {
        if(!envioRepository.existsById(id)){
            throw new RuntimeException(" envio no encontrado con id "+ id);

        }envioRepository.deleteById(id);

    }

    @Override
    public List<Envio> findByEstado(String estado) {
        return envioRepository.findByEstado(estado);
    }

    //metodos logica de negocio
    public double calculateCostoEnvio(double pesoKg, String destino){
        double costoBase= 10000;
        if(pesoKg>50) costoBase *= 1.2;
        if("Internacional" .equalsIgnoreCase(destino)) costoBase*=1.5;
        return costoBase;
    }

    private void validarTransaccionEstado(String eActual, String eNuevo){
        boolean permitida = switch (eActual){
            case "PENDIENTE" -> eNuevo.equals("EN_RUTA") ||
                    eNuevo.equals("CANCELADO");

            case "EN_RUTA" -> eNuevo.equals("ENTREGADO");
            default -> false;
        };

        if(!permitida){
            throw new RuntimeException("No se puede cambiar de: "+ eActual+"a "+eNuevo);
        }

    }


    private boolean cambiarPesoODestino(Envio existente, Envio actualizado){
        return existente.getPesoKg() != actualizado.getPesoKg()
                || !existente.getDestino().equals(actualizado.getDestino());
    }
}
