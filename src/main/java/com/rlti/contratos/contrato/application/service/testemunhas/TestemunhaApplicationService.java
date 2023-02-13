package com.rlti.contratos.contrato.application.service.testemunhas;

import com.rlti.contratos.contrato.application.api.testemunha.TestemunhaRequest;
import com.rlti.contratos.contrato.application.api.testemunha.TestemunhaResponse;
import com.rlti.contratos.contrato.application.repository.testemunhas.TestemunhaRepository;
import com.rlti.contratos.contrato.domain.Testemunha;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Log4j2
public class TestemunhaApplicationService implements TestemunhaService {
    private final TestemunhaRepository testemunhaRepository;

    @Override
    public Testemunha criaTestemunhas(TestemunhaRequest testemunhaRequest) {
        log.info("[inicia] TestemunhasApplicationService - criaTestemunhas");
        Testemunha testemunha = testemunhaRepository.criaTestemunhas(new Testemunha(testemunhaRequest));
        log.info("[finaliza] TestemunhasApplicationService - criaTestemunhas");
        return testemunha;
    }

    @Override
    public List<Testemunha> saveAll(List<TestemunhaRequest> testemunhaRequestList) {
        log.info("[inicia] TestemunhasApplicationService - criaTestemunhas");
        List<Testemunha> testemunhas =  testemunhaRepository.saveAll((List<Testemunha>) new Testemunha(testemunhaRequestList));
        log.info("[finaliza] TestemunhasApplicationService - criaTestemunhas");
        return  testemunhas;
    }
}
