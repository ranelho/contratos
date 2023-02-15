package com.rlti.contratos.contrato.application.repository;

import com.rlti.contratos.contrato.domain.Contratada;

import java.util.Optional;

public interface ContratadaRepository {
    Contratada salva(Contratada contratada);
    Optional<Contratada> findByCpfOrCnpj(String cnpjContratada);
}
