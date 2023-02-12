package com.rlti.contratos.contrato.application.service.contrantante;

import com.rlti.contratos.contrato.application.api.contratante.ContratanteRequest;
import com.rlti.contratos.contrato.application.api.contratante.ContratanteResponse;
import com.rlti.contratos.contrato.domain.Contratante;

public interface ContratanteService {
    ContratanteResponse criaContratante(ContratanteRequest contratanteRequest);
    Contratante alteraContratante(ContratanteRequest request);
}
