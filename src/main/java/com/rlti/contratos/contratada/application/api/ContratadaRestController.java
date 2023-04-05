package com.rlti.contratos.contratada.application.api;

import com.rlti.contratos.contratada.application.service.ContratadaService;
import com.rlti.contratos.contrato.application.api.ContratoListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Override
    public List<ContratoListResponse> allContratos(String cpfOrCnpj) {
        log.info("[inicia] ContratadaRestController - allContratos");
        List<ContratoListResponse> listContratos = contratadaService.allContratos(cpfOrCnpj);
        log.info("[finaliza] ContratadaRestController - allContratos");
        return listContratos;
    }
}