package com.rlti.contratos.contrato.application.service.contrato;

import com.rlti.contratos.contrato.application.api.contrato.ContratoRequest;
import com.rlti.contratos.contrato.application.api.contrato.ContratoResponse;
import com.rlti.contratos.contrato.domain.Contrato;

public interface ContratoService {
    ContratoResponse postContratoSemCadastro(ContratoRequest contratoRequest);
    ContratoResponse getContratoById(Long idContrato);
}
