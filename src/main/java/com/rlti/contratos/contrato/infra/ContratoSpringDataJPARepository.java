package com.rlti.contratos.contrato.infra;

import com.rlti.contratos.contrato.domain.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContratoSpringDataJPARepository extends JpaRepository<Contrato, Long> {
    @Query(value = "SELECT * FROM contrato WHERE contratada_id = :idContratada", nativeQuery = true)
    List<Contrato> findAllByIdContratada(Long idContratada);
}
