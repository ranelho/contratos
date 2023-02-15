package com.rlti.contratos.contrato.infra.contratante;

import com.rlti.contratos.contrato.domain.Contratante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ContratanteSpringDataJPARepository extends JpaRepository<Contratante, Long> {
    @Query("SELECT c FROM Contratante c WHERE c.cpfOuCnpj = :cpfOrCnpj")
    Optional<Contratante> findByCpfOrCnpj(String cpfOrCnpj );
}
