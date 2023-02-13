package com.rlti.contratos.contrato.application.service.testemunhas;

import com.rlti.contratos.contrato.application.api.testemunha.TestemunhaRequest;
import com.rlti.contratos.contrato.application.api.testemunha.TestemunhaResponse;

public interface TestemunhaService {
    TestemunhaResponse criaTestemunhas(TestemunhaRequest testemunhaRequest);
}
