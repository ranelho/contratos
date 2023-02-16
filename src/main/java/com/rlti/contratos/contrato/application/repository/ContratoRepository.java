package com.rlti.contratos.contrato.application.repository;

import com.rlti.contratos.contrato.domain.Contrato;

import java.util.List;

public interface ContratoRepository {
    Contrato salva(Contrato contrato);
    Contrato getContratoById(Long idContrato);
    List<Contrato> allContratos(Long idContratada);
    void deleta(Long idContrato);
}
