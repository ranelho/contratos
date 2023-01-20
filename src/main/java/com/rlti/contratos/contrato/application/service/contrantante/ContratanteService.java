package com.rlti.contratos.contrato.application.service.contrantante;

import com.rlti.contratos.contrato.application.api.contratante.ContratanteIdResponse;
import com.rlti.contratos.contrato.application.api.contratante.ContratanteRequest;
import com.rlti.contratos.contrato.application.api.contratante.ContratanteResponse;

public interface ContratanteService {
    ContratanteResponse criaContratante(ContratanteRequest contratanteRequest);
}
