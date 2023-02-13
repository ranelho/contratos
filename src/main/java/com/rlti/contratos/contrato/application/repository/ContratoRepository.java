package com.rlti.contratos.contrato.application.repository;

import com.rlti.contratos.contrato.domain.Contrato;

public interface ContratoRepository {
    Contrato salva(Contrato contrato);
    Contrato getContratoById(Long idContrato);
}
