package com.rlti.contratos.contrato.application.service;

import com.rlti.contratos.contrato.application.api.ContratoRequest;
import com.rlti.contratos.contrato.application.api.ContratoResponse;
import com.rlti.contratos.contrato.application.repository.ContratoRepository;
import com.rlti.contratos.contratada.application.service.ContratanteService;
import com.rlti.contratos.contratante.application.service.ContratadaService;
import com.rlti.contratos.testemunha.application.service.TestemunhaService;
import com.rlti.contratos.contratada.domain.Contratada;
import com.rlti.contratos.contratante.domain.Contratante;
import com.rlti.contratos.contrato.domain.Contrato;
import com.rlti.contratos.testemunha.domain.Testemunha;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class ContratoApplicationService implements ContratoService {
    private final ContratoRepository contratoRepository;
    private final ContratanteService contratanteService;
    private final ContratadaService contratadaService;
    private final TestemunhaService testemunhaService;

    @Override
    public ContratoResponse novoContrato(ContratoRequest contratoRequest) {
        log.info("[inicia] ContratoApplicationService - postContrato");
        Contratada contratada = contratadaService.alteraContratada(contratoRequest.getContratadaRequest());
        Contratante contratante = contratanteService.alteraContratante(contratoRequest.getContratanteRequest());
        Testemunha testemunha1 = testemunhaService.criaTestemunhas(contratoRequest.getTestemunha1());
        Testemunha testemunha2 = testemunhaService.criaTestemunhas(contratoRequest.getTestemunha2());
        Contrato contrato = contratoRepository.salva(new Contrato(contratoRequest, contratada, contratante, testemunha1, testemunha2));
        log.info("[finaliza] ContratoApplicationService - postContrato");
        return new ContratoResponse(contrato);
    }

    @Override
    public ContratoResponse getContratoById(Long idContrato) {
        log.info("[inicia] ContratoApplicationService - getContratoById");
        Contrato optionalContrato = contratoRepository.getContratoById(idContrato);
        log.info("[finaliza] ContratoApplicationService - getContratoById");
        return new ContratoResponse(optionalContrato);
    }

    @Override
    public void deleteContratoById(Long idContrato) {
        log.info("[inicia] ContratoApplicationService - deleteContratoById");
        getContratoById(idContrato);
        contratoRepository.deleta(idContrato);
        log.info("[finaliza] ContratoApplicationService - deleteContratoById");
    }
}