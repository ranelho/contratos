package com.rlti.contratos.testemunha.infra;

import com.rlti.contratos.contrato.application.repository.testemunhas.TestemunhaRepository;
import com.rlti.contratos.testemunha.domain.Testemunha;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Log4j2
public class TestemunhaInfraRepository implements TestemunhaRepository {
    private final TestemunhaSpringDataJPARepository testemunhaSpringDataJPARepository;

    @Override
    public Testemunha salva(Testemunha testemunhas) {
        log.info("[inicia] TestemunhaInfraRepository - salva");
        testemunhaSpringDataJPARepository.save(testemunhas);
        log.info("[finaliza] TestemunhaInfraRepository - salva");
        return testemunhas;
    }

    @Override
    public Optional<Testemunha> findByCpf(String cpf) {
        log.info("[inicia] TestemunhaInfraRepository - salva");
        Optional<Testemunha> optionalTestemunha = testemunhaSpringDataJPARepository.findByCpf(cpf);
        log.info("[finaliza] TestemunhaInfraRepository - salva");
        return optionalTestemunha;
    }
}