package com.rlti.contratos.testemunha.infra;

import com.rlti.contratos.testemunha.domain.Testemunha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestemunhaSpringDataJPARepository extends JpaRepository<Testemunha, Long> {
    Optional<Testemunha> findByCpf(String cpf);
}
