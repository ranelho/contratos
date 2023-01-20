package com.rlti.contratos.contrato.application.service.contratada;

import com.rlti.contratos.contrato.application.api.contratada.ContratadaIdResponse;
import com.rlti.contratos.contrato.application.api.contratada.ContratadaRequest;

public interface ContratadaService {
    ContratadaIdResponse criaContratada(ContratadaRequest contratadaRequest);
}
