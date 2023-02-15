package com.rlti.contratos.contratada.application.api;

import com.rlti.contratos.contratante.domain.ContratadaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Log4j2
public class ContratadaRestController implements ContratadaApi {

    private final ContratadaService contratadaService;

    @Override
    public ContratadaIdResponse postContratada(ContratadaRequest contratadaRequest) {
        log.info("[inicia] ContratadaRestController - postContrato");
        ContratadaIdResponse contratada = contratadaService.criaContratada(contratadaRequest);
        log.info("[finaliza] ContratadaRestController - postContrato");
        return contratada;
    }
}