package com.rlti.contratos.contratada.application.repository;

import com.rlti.contratos.contratada.domain.Contratada;
import com.rlti.contratos.contrato.domain.Contrato;

import java.util.List;
import java.util.Optional;

public interface ContratadaRepository {
    Contratada salva(Contratada contratada);
    Optional<Contratada> findByCpfOrCnpj(String cnpjContratada);
}
