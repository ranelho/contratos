package com.rlti.contratos.contrato.application.repository.testemunhas;

import com.rlti.contratos.contrato.domain.Testemunha;

import java.util.List;

public interface TestemunhaRepository {
    Testemunha criaTestemunhas(Testemunha testemunhas);
    List<Testemunha> saveAll(List<Testemunha> list);
}
