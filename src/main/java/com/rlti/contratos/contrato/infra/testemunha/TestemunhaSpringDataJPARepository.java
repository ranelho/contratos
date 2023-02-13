package com.rlti.contratos.contrato.infra.testemunha;

import com.rlti.contratos.contrato.domain.Testemunha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestemunhaSpringDataJPARepository extends JpaRepository<Testemunha, Long> {
}
