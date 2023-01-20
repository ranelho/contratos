package com.rlti.contratos.contrato.application.repository.contratante;

import com.rlti.contratos.contrato.domain.Contratante;

import java.util.Optional;

public interface ContratanteRepository {
    Contratante salva(Contratante contratante);
    Optional<Contratante> findByCnpj(String cnpjContratante);
}
