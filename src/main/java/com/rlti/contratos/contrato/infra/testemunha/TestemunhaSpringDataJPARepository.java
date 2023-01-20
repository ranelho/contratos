package com.rlti.contratos.contrato.infra.testemunha;

import com.rlti.contratos.contrato.domain.Testemunhas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestemunhaSpringDataJPARepository extends JpaRepository<Testemunhas, Long> {
}
