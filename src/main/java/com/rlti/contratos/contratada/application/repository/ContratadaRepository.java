package com.rlti.contratos.contratada.application.repository;

import com.rlti.contratos.contratada.domain.Contratada;

import java.util.Optional;

public interface ContratadaRepository {
    Contratada salva(Contratada contratada);
    Optional<Contratada> findByCpfOrCnpj(String cnpjContratada);
}
