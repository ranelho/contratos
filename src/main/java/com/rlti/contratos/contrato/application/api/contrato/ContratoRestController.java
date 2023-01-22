package com.rlti.contratos.contrato.application.api.contrato;

import com.rlti.contratos.contrato.application.service.contrato.ContratoService;
import com.rlti.contratos.contrato.domain.Contrato;
import com.rlti.contratos.contrato.domain.ReplaceTextInDocument;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Log4j2
public class ContratoRestController implements ContratoApi {
    private final ContratoService contratoService;

    @Override
    public ContratoResponse postContratoSemCadastro(ContratoRequest contratoRequest) {
        log.info("[inicia] ContratoController - postContrato");
        ContratoResponse contratoResponse = contratoService.postContratoSemCadastro(contratoRequest);
       // ReplaceTextInDocument.upadate(contratoResponse);
        log.info("[finaliza] ContratoController - postContrato");
        return contratoResponse;
    }

    @Override
    public ContratoResponse getContratoById(Long idContrato) {
        log.info("[inicia] ContratoController - getContratoById");
        ContratoResponse contratoResponse = contratoService.getContratoById(idContrato);
        ReplaceTextInDocument.upadate(contratoResponse);
        log.info("[finaliza] ContratoController - getContratoById");
        return contratoResponse;
    }
}
