package com.rlti.contratos.contrato.application.service.contrato;

import com.rlti.contratos.contrato.application.api.contrato.ContratoRequest;
import com.rlti.contratos.contrato.application.api.contrato.ContratoResponse;
import com.rlti.contratos.contrato.application.repository.ContratadaRepository;
import com.rlti.contratos.contrato.application.repository.ContratanteRepository;
import com.rlti.contratos.contrato.application.repository.ContratoRepository;
import com.rlti.contratos.contrato.application.repository.TestemunhaRepository;
import com.rlti.contratos.contrato.application.service.contrantante.ContratanteService;
import com.rlti.contratos.contrato.domain.Contratada;
import com.rlti.contratos.contrato.domain.Contratante;
import com.rlti.contratos.contrato.domain.Contrato;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log4j2
public class ContratoApplicationService implements ContratoService {
    private final ContratoRepository contratoRepository;
    private final ContratadaRepository contratadaRepository;
    private final ContratanteRepository contratanteRepository;
    private final TestemunhaRepository testemunhaRepository;
    private final ContratanteService contratanteService;
    private Contratada contratada;
  // private Contratante contratante;

    @Override
    public ContratoResponse postContratoSemCadastro(ContratoRequest contratoRequest) {
        log.info("[inicia] ContratoApplicationService - postContrato");
        Optional<Contratada> optionalContratada = contratadaRepository.findByCnpj(contratoRequest.getContratadaRequest()
                .getCnpjContratada());
        if(optionalContratada.isPresent()){
            contratada = optionalContratada.get();
        }else{
            contratada = new Contratada(contratoRequest.getContratadaRequest());
            contratadaRepository.salva(contratada);
        }

        /*Optional<Contratante> optionalContratante = contratanteRepository.findByCnpj(contratoRequest.getContratanteRequest()
                .getCnpjContratante());
        if(optionalContratante.isPresent()){
            contratante = optionalContratante.get();
        }else{
            contratante = new Contratante(contratoRequest.getContratanteRequest());
            contratanteRepository.salva(contratante);
        }*/

        Contratante contratante = contratanteService.alteraContratante(contratoRequest.getContratanteRequest());

        Contrato contrato = new Contrato(contratoRequest, contratada, contratante);
        testemunhaRepository.salva(contrato.getTestemunhas());
        contratoRepository.cria(contrato);
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
}