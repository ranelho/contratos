package com.rlti.contratos.contratante.infra;

import com.rlti.contratos.contratante.application.repository.ContratanteRepository;
import com.rlti.contratos.contratante.domain.Contratante;
import com.rlti.contratos.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Log4j2
public class ContratanteInfraRepository implements ContratanteRepository {
    private final ContratanteSpringDataJPARepository contratanteSpringDataJPARepository;

    @Override
    public Contratante salva(Contratante contratante) {
        log.info("[inicia] ContratanteInfraRepository - salva");
        try {
            contratanteSpringDataJPARepository.save(contratante);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Contratante já cadastrado", e);
        }
        log.info("[finaliza] ContratanteInfraRepository - salva");
        return contratante;
    }

    @Override
    public Optional<Contratante> findByCpfOrCnpj(String cpfOrCnpj) {
        log.info("[inicia] ContratanteInfraRepository - findByCnpj");
        Optional<Contratante> optionalContratante = contratanteSpringDataJPARepository.findByCpfCnpj(cpfOrCnpj);
        log.info("[finaliza] ContratanteInfraRepository - findByCnpj");
        return  optionalContratante;
    }
}
