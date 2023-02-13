package com.rlti.contratos.contrato.application.service.testemunhas;

import com.rlti.contratos.contrato.application.api.testemunha.TestemunhasRequest;
import com.rlti.contratos.contrato.application.api.testemunha.TestemunhasResponse;
import com.rlti.contratos.contrato.application.repository.testemunhas.TestemunhasRepository;
import com.rlti.contratos.contrato.domain.Testemunhas;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class TestemunhasApplicationService implements TestemunhasService {
    private final TestemunhasRepository testemunhasRepository;

    @Override
    public TestemunhasResponse criaTestemunhas(TestemunhasRequest testemunhasRequest) {
        log.info("[inicia] TestemunhasApplicationService - criaTestemunhas");
        Testemunhas testemunhas = testemunhasRepository.criaTestemunhas(new Testemunhas(testemunhasRequest));
        log.info("[finaliza] TestemunhasApplicationService - criaTestemunhas");
        return new TestemunhasResponse(testemunhas);
    }
}
