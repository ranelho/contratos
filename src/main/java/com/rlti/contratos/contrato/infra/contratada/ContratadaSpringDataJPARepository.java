package com.rlti.contratos.contrato.infra.contratada;

import com.rlti.contratos.contrato.domain.Contratada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContratadaSpringDataJPARepository extends JpaRepository<Contratada, Long> {
    Optional<Contratada> findByCnpjContratada(String cnpjContratada);
}
