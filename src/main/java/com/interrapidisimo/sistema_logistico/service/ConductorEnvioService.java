package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.dto.ConductorEnvioDto;
import com.interrapidisimo.sistema_logistico.model.ConductorEnvio;

public interface ConductorEnvioService {
    ConductorEnvio asignarConductorAEnvio(Long envioId, Long conductorId, String responsable, String observaciones);
}
