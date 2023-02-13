package com.rlti.contratos.contrato.application.service.testemunhas;

import com.rlti.contratos.contrato.application.api.testemunha.TestemunhasRequest;
import com.rlti.contratos.contrato.application.api.testemunha.TestemunhasResponse;

public interface TestemunhasService {
    TestemunhasResponse criaTestemunhas(TestemunhasRequest testemunhasRequest);
}
