package com.rlti.contratos.contrato.infra;

import com.rlti.contratos.contrato.domain.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoSpringDataJPARepository extends JpaRepository<Contrato, Long> {
}
