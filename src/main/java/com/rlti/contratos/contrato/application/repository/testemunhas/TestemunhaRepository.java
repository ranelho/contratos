package com.rlti.contratos.contrato.application.repository.testemunhas;

import com.rlti.contratos.contrato.domain.Testemunha;

import java.util.Optional;

public interface TestemunhaRepository {
    Testemunha salva(Testemunha testemunhas);
    Optional<Testemunha> findByCpf(String cpf);
}
