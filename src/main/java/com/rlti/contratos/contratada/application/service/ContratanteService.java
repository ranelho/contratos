package com.rlti.contratos.contratada.application.service;

import com.rlti.contratos.contratante.application.api.ContratanteRequest;
import com.rlti.contratos.contratante.application.api.ContratanteResponse;
import com.rlti.contratos.contratante.domain.Contratante;

public interface ContratanteService {
    ContratanteResponse criaContratante(ContratanteRequest contratanteRequest);
    Contratante alteraContratante(ContratanteRequest request);
}
