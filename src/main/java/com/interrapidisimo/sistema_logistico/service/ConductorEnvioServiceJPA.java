package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.dto.ConductorEnvioDto;
import com.interrapidisimo.sistema_logistico.model.Conductor;
import com.interrapidisimo.sistema_logistico.model.ConductorEnvio;
import com.interrapidisimo.sistema_logistico.model.Envio;
import com.interrapidisimo.sistema_logistico.repository.ConductorEnvioRepository;
import com.interrapidisimo.sistema_logistico.repository.ConductorRepository;
import com.interrapidisimo.sistema_logistico.repository.EnvioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ConductorEnvioServiceJPA implements ConductorEnvioService {
    private final ConductorEnvioRepository conductorEnvioRepository;
    private final ConductorRepository conductorRepository;
    private final EnvioRepository envioRepository;

    @Autowired
    public ConductorEnvioServiceJPA(ConductorEnvioRepository conductorEnvioRepository, ConductorRepository conductorRepository, EnvioRepository envioRepository) {
        this.conductorEnvioRepository = conductorEnvioRepository;
        this.conductorRepository = conductorRepository;
        this.envioRepository = envioRepository;
    }


    @Override
    @Transactional
    public ConductorEnvio asignarConductorAEnvio(Long envioId, Long conductorId, String responsable, String observaciones) {

        Envio envio = envioRepository.findById(envioId)
                .orElseThrow(() -> new RuntimeException("Envio no encontrado con id " + envioId));

        Conductor conductor = conductorRepository.findById(conductorId)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado con id " + conductorId));

        if (!"PENDIENTE".equals(envio.getEstado())) {
            throw new RuntimeException("Solo se puede asignar un conductor a un envio PENDIENTE");
        }

        ConductorEnvio asignacion = new ConductorEnvio(envio, conductor, LocalDate.now(), responsable, observaciones);

        envio.setEstado("EN_RUTA");
        envioRepository.save(envio);

        return conductorEnvioRepository.save(asignacion);
    }
}
