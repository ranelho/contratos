package com.rlti.contratos.contrato.application.service.contratada;

import com.rlti.contratos.contrato.application.api.contratada.ContratadaIdResponse;
import com.rlti.contratos.contrato.application.api.contratada.ContratadaRequest;
import com.rlti.contratos.contrato.domain.Contratada;

public interface ContratadaService {
    ContratadaIdResponse criaContratada(ContratadaRequest contratadaRequest);
    Contratada alteraContratada(ContratadaRequest request);
}
