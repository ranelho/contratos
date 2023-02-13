package com.rlti.contratos.contrato.infra.testemunha;

import com.rlti.contratos.contrato.application.repository.testemunhas.TestemunhaRepository;
import com.rlti.contratos.contrato.domain.Testemunha;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
@Log4j2
public class TestemunhaInfraRepository implements TestemunhaRepository {
    private final TestemunhaSpringDataJPARepository testemunhaSpringDataJPARepository;

    @Override
    public Testemunha criaTestemunhas(Testemunha testemunhas) {
        log.info("[inicia] TestemunhaInfraRepository - salva");
        testemunhaSpringDataJPARepository.save(testemunhas);
        log.info("[finaliza] TestemunhaInfraRepository - salva");
        return testemunhas;
    }

    @Override
    public List<Testemunha> saveAll(List<Testemunha> list) {
        log.info("[inicia] TestemunhaInfraRepository - saveAll");
        testemunhaSpringDataJPARepository.saveAll(list);
        log.info("[finaliza] TestemunhaInfraRepository - saveAll");
        return list;
    }
}
