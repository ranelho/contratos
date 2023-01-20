package com.rlti.contratos.contrato.application.service.testemunhas;

import com.rlti.contratos.contrato.application.api.testemunha.TestemunhasRequest;
import com.rlti.contratos.contrato.domain.Testemunhas;

public interface TestemunhasService {
    Testemunhas criaTestemunhas(TestemunhasRequest testemunhasRequest);
}
