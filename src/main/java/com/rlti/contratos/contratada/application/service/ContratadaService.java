package com.rlti.contratos.contratada.application.service;

import com.rlti.contratos.contratada.application.api.ContratadaIdResponse;
import com.rlti.contratos.contratada.application.api.ContratadaRequest;
import com.rlti.contratos.contratada.domain.Contratada;
import com.rlti.contratos.contrato.application.api.ContratoListResponse;

import java.util.List;

public interface ContratadaService {
    ContratadaIdResponse criaContratada(ContratadaRequest contratadaRequest);
    Contratada alteraContratada(ContratadaRequest request);
    List<ContratoListResponse> allContratos(String cpfOrCnpj);
}