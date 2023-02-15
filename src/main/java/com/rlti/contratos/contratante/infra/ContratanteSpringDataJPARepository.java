package com.rlti.contratos.contratante.infra;

import com.rlti.contratos.contratante.domain.Contratante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ContratanteSpringDataJPARepository extends JpaRepository<Contratante, Long> {
    @Query("SELECT c FROM Contratante c WHERE c.cpfOuCnpj = :cpfOrCnpj")
    Optional<Contratante> findByCpfOrCnpj(String cpfOrCnpj );
}
