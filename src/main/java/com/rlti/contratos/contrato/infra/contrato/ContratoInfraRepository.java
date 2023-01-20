package com.rlti.contratos.contrato.infra.contrato;

import com.rlti.contratos.contrato.application.repository.ContratoRepository;
import com.rlti.contratos.contrato.domain.Contrato;
import com.rlti.contratos.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Log4j2
public class ContratoInfraRepository implements ContratoRepository {

    private final ContratoSpringDataJPARepository contratoSpringaDataJPARespository;

    @Override
    public Contrato cria(Contrato contrato) {
        log.info("[inicia] ContratoInfraRepository - cria");
        contratoSpringaDataJPARespository.save(contrato);
        log.info("[finaliza] ContratoInfraRepository - cria");
        return contrato;
    }

    @Override
    public Contrato getContratoById(Long idContrato) {
        log.info("[inicia] ContratoInfraRepository - getContratoById");
        Optional<Contrato> optionalContrato = contratoSpringaDataJPARespository.findById(idContrato);
        Contrato contrato = optionalContrato
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Contrato não encontrado!"));
        log.info("[finaliza] ContratoInfraRepository - getContratoById");
        return contrato;
    }
}
