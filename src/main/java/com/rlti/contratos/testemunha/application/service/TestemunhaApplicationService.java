package com.rlti.contratos.testemunha.application.service;

import com.rlti.contratos.testemunha.application.api.TestemunhaRequest;
import com.rlti.contratos.contrato.application.repository.testemunhas.TestemunhaRepository;
import com.rlti.contratos.testemunha.domain.Testemunha;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log4j2
public class TestemunhaApplicationService implements TestemunhaService {
    private final TestemunhaRepository testemunhaRepository;

    @Override
    public Testemunha criaTestemunhas(TestemunhaRequest testemunhaRequest) {
        log.info("[inicia] TestemunhasApplicationService - criaTestemunhas");
        Optional<Testemunha> optionalTestemunha = testemunhaRepository.findByCpf(testemunhaRequest.getCpf());
        Testemunha testemunha = optionalTestemunha.orElseGet(() -> testemunhaRepository.salva(new Testemunha(testemunhaRequest)) );
        if(!testemunha.getNome().equals(testemunhaRequest.getNome())){
           testemunha.altera(testemunhaRequest);
           testemunhaRepository.salva(testemunha);
        }
        log.info("[finaliza] TestemunhasApplicationService - criaTestemunhas");
        return testemunha;
    }
}