package com.rlti.contratos.contrato.application.service.contrato;

import com.rlti.contratos.contrato.application.api.contrato.ContratoRequest;
import com.rlti.contratos.contrato.domain.Contrato;

public interface ContratoService {
    Contrato postContratoSemCadastro(ContratoRequest contratoRequest);
    Contrato getContratoById(Long idContrato);
}
