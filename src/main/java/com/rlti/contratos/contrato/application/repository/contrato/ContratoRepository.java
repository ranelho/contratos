package com.rlti.contratos.contrato.application.repository.contrato;

import com.rlti.contratos.contrato.domain.Contrato;

public interface ContratoRepository {
    Contrato cria(Contrato contrato);
    Contrato getContratoById(Long idContrato);
}
