package com.rlti.contratos.contratante.domain;

import com.rlti.contratos.contratada.application.api.ContratadaIdResponse;
import com.rlti.contratos.contratada.application.api.ContratadaRequest;
import com.rlti.contratos.contratada.domain.Contratada;

public interface ContratadaService {
    ContratadaIdResponse criaContratada(ContratadaRequest contratadaRequest);
    Contratada alteraContratada(ContratadaRequest request);
}
