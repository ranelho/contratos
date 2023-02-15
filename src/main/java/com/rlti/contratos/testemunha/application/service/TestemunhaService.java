package com.rlti.contratos.testemunha.application.service;

import com.rlti.contratos.testemunha.application.api.TestemunhaRequest;
import com.rlti.contratos.testemunha.domain.Testemunha;

public interface TestemunhaService {
    Testemunha criaTestemunhas(TestemunhaRequest testemunhaRequest);
}
