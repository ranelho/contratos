package com.rlti.contratos.contratada.infra;

import com.rlti.contratos.contratada.application.repository.ContratadaRepository;
import com.rlti.contratos.contratada.domain.Contratada;
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
public class ContratadaInfraRepository implements ContratadaRepository {

    private final ContratadaSpringDataJPARepository contratadaSpringDataJPARepository;

    @Override
    public Contratada salva(Contratada contratada) {
        log.info("[inicia] ContratadaInfraRepository - salva");
        try {
            contratadaSpringDataJPARepository.save(contratada);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Contratada já cadastrada", e);
        }
        log.info("[finaliza] ContratadaInfraRepository - salva");
        return contratada;
    }

    @Override
    public Optional<Contratada> findByCpfOrCnpj(String cpfOrCnpj) {
        log.info("[inicia] ContratadaInfraRepository - findByCpfOrCnpj");
        Optional<Contratada>  optionalContratada = contratadaSpringDataJPARepository.findByCpfOrCnpj(cpfOrCnpj);
        log.info("[finaliza] ContratadaInfraRepository - findByCpfOrCnpj");
        return  optionalContratada;
    }
}
