package com.rlti.contratos.contrato.infra.contratante;

import com.rlti.contratos.contrato.application.repository.contratante.ContratanteRepository;
import com.rlti.contratos.contrato.domain.Contratada;
import com.rlti.contratos.contrato.domain.Contratante;
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
    public Optional<Contratante> findByCnpj(String cnpjContratante) {
        log.info("[inicia] ContratadaInfraRepository - findByCnpj");
        Optional<Contratante> optionalContratante = contratanteSpringDataJPARepository.findByCnpjContratante(cnpjContratante);
        /*Contratante contratada = optionalContratante
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Contratado não encontrado!"));*/
        log.info("[inicia] ContratadaInfraRepository - findByCnpj");
        return  optionalContratante;
    }
}
