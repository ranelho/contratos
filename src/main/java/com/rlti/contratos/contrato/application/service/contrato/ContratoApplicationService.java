package com.rlti.contratos.contrato.application.service.contrato;

import com.rlti.contratos.contrato.application.api.contrato.ContratoRequest;
import com.rlti.contratos.contrato.application.api.contrato.ContratoResponse;
import com.rlti.contratos.contrato.application.repository.ContratoRepository;
import com.rlti.contratos.contrato.application.repository.TestemunhaRepository;
import com.rlti.contratos.contrato.application.service.contrantante.ContratanteService;
import com.rlti.contratos.contrato.application.service.contratada.ContratadaService;
import com.rlti.contratos.contrato.domain.Contratada;
import com.rlti.contratos.contrato.domain.Contratante;
import com.rlti.contratos.contrato.domain.Contrato;
import com.rlti.contratos.contrato.domain.Testemunhas;
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
    private final TestemunhaRepository testemunhaRepository;
    // private Contratante contratante;
    // private Contratada contratada;
    //private final ContratadaRepository contratadaRepository;
    //private final ContratanteRepository contratanteRepository;

    @Override
    public ContratoResponse postContratoSemCadastro(ContratoRequest contratoRequest) {
        log.info("[inicia] ContratoApplicationService - postContrato");
        Contratada contratada = contratadaService.alteraContratada(contratoRequest.getContratadaRequest());
        Contratante contratante = contratanteService.alteraContratante(contratoRequest.getContratanteRequest());
        Testemunhas testemunhas = testemunhaRepository.salva(new Testemunhas(contratoRequest.getTestemunhas()));
        Contrato contrato = contratoRepository.salva(new Contrato(contratoRequest, contratada, contratante, testemunhas));
        log.info("[finaliza] ContratoApplicationService - postContrato");
        return new ContratoResponse(contrato);

       /*Optional<Contratada> optionalContratada = contratadaRepository.findByCnpj(contratoRequest.getContratadaRequest()
                .getCnpjContratada());
        if(optionalContratada.isPresent()){
            contratada = optionalContratada.get();
        }else{
            contratada = new Contratada(contratoRequest.getContratadaRequest());
            contratadaRepository.salva(contratada);
        }

        Optional<Contratante> optionalContratante = contratanteRepository.findByCnpj(contratoRequest.getContratanteRequest()
                .getCnpjContratante());
        if(optionalContratante.isPresent()){
            contratante = optionalContratante.get();
        }else{
            contratante = new Contratante(contratoRequest.getContratanteRequest());
            contratanteRepository.salva(contratante);
        }
        testemunhaRepository.salva(contrato.getTestemunhas());
        contratoRepository.salva(contrato);
        */
    }

    @Override
    public ContratoResponse getContratoById(Long idContrato) {
        log.info("[inicia] ContratoApplicationService - getContratoById");
        Contrato optionalContrato = contratoRepository.getContratoById(idContrato);
        log.info("[finaliza] ContratoApplicationService - getContratoById");
        return new ContratoResponse(optionalContrato);
    }
}