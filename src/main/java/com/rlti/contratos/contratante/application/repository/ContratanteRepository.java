package com.rlti.contratos.contratante.application.repository;

import com.rlti.contratos.contratante.domain.Contratante;

import java.util.Optional;

public interface ContratanteRepository {
    Contratante salva(Contratante contratante);
    Optional<Contratante> findByCpfOrCnpj(String cnpjContratante);
}
