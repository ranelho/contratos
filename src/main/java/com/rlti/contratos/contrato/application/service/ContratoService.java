package com.rlti.contratos.contrato.application.service;

import com.rlti.contratos.contrato.application.api.ContratoRequest;
import com.rlti.contratos.contrato.application.api.ContratoResponse;

public interface ContratoService {
    ContratoResponse postContratoSemCadastro(ContratoRequest contratoRequest);
    ContratoResponse getContratoById(Long idContrato);
}
