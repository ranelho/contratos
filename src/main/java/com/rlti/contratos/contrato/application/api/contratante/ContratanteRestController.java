package com.rlti.contratos.contrato.application.api.contratante;

import com.rlti.contratos.contrato.application.service.contrantante.ContratanteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Log4j2
public class ContratanteRestController implements ContratanteApi {
    private final ContratanteService contratanteService;

    @Override
    public ContratanteResponse postContratante(ContratanteRequest contratanteRequest) {
        log.info("[inicia] ContratanteRestController - postContrato");
        ContratanteResponse contratante = contratanteService.criaContratante(contratanteRequest);
        log.info("[finaliza] ContratanteRestController - postContrato");
        return contratante;
    }
}