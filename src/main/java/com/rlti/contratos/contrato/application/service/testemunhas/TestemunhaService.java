package com.rlti.contratos.contrato.application.service.testemunhas;

import com.rlti.contratos.contrato.application.api.testemunha.TestemunhaRequest;
import com.rlti.contratos.contrato.domain.Testemunha;

import java.util.List;

public interface TestemunhaService {
    Testemunha criaTestemunhas(TestemunhaRequest testemunhaRequest);
    List<Testemunha> saveAll(List<TestemunhaRequest> testemunhas);
}
