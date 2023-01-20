package com.rlti.contratos.contrato.application.repository;

import com.rlti.contratos.contrato.domain.Contrato;

public interface ContratoRepository {
    Contrato cria(Contrato contrato);
    Contrato getContratoById(Long idContrato);
}
