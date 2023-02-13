package com.rlti.contratos.contrato.application.service.testemunhas;

import com.rlti.contratos.contrato.application.api.testemunha.TestemunhaRequest;
import com.rlti.contratos.contrato.application.api.testemunha.TestemunhaResponse;
import com.rlti.contratos.contrato.application.repository.testemunhas.TestemunhasRepository;
import com.rlti.contratos.contrato.domain.Testemunha;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class TestemunhaApplicationService implements TestemunhaService {
    private final TestemunhasRepository testemunhasRepository;

    @Override
    public TestemunhaResponse criaTestemunhas(TestemunhaRequest testemunhaRequest) {
        log.info("[inicia] TestemunhasApplicationService - criaTestemunhas");
        Testemunha testemunhas = testemunhasRepository.criaTestemunhas(new Testemunha(testemunhaRequest));
        log.info("[finaliza] TestemunhasApplicationService - criaTestemunhas");
        return new TestemunhaResponse(testemunhas);
    }
}
