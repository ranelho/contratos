package com.rlti.contratos.contratada.infra;

import com.rlti.contratos.contratada.domain.Contratada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ContratadaSpringDataJPARepository extends JpaRepository<Contratada, Long> {
    @Query("SELECT c FROM Contratada c WHERE c.cpfOuCnpj = :cpfOrCnpj")
    Optional<Contratada> findByCpfOrCnpj(String cpfOrCnpj);
}
