package com.rlti.contratos.contrato.infra.contratante;

import com.rlti.contratos.contrato.domain.Contratante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContratanteSpringDataJPARepository extends JpaRepository<Contratante, Long> {
    Optional<Contratante> findByCnpjContratante(String cnpjContratante );
}
