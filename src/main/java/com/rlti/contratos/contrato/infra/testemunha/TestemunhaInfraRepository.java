package com.rlti.contratos.contrato.infra.testemunha;

import com.rlti.contratos.contrato.application.repository.TestemunhaRepository;
import com.rlti.contratos.contrato.domain.Testemunhas;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
@Log4j2
public class TestemunhaInfraRepository implements TestemunhaRepository {
    private final TestemunhaSpringDataJPARepository testemunhaSpringDataJPARepository;

    @Override
    public Testemunhas salva(Testemunhas testemunhas) {
        log.info("[inicia] TestemunhaInfraRepository - salva");
        testemunhaSpringDataJPARepository.save(testemunhas);
        log.info("[finaliza] TestemunhaInfraRepository - salva");
        return testemunhas;
    }
}
