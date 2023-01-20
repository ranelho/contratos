package com.rlti.contratos.contrato.application.service.contrato;

import com.rlti.contratos.contrato.application.api.contrato.ContratoRequestSemCadastro;
import com.rlti.contratos.contrato.application.repository.ContratadaRepository;
import com.rlti.contratos.contrato.application.repository.ContratanteRepository;
import com.rlti.contratos.contrato.application.repository.ContratoRepository;
import com.rlti.contratos.contrato.application.repository.TestemunhaRepository;
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

    @Override
    public Contrato postContratoSemCadastro(ContratoRequestSemCadastro contratoRequestSemCadastro) {
        log.info("[inicia] ContratoApplicationService - postContrato");
        Optional<Contratada> optionalContratada = contratadaRepository.findByCnpj(contratoRequestSemCadastro.getContratada().getCnpjContratada());
        Optional<Contratante> optionalContratante = contratanteRepository.findByCnpj(contratoRequestSemCadastro.getContratante().getCnpjContratante());
        Contrato contrato = new Contrato(contratoRequestSemCadastro, optionalContratada, optionalContratante);
        if(optionalContratada.isEmpty()){
            contratadaRepository.salva(contrato.getContratada());
        }
        if(optionalContratante.isEmpty()){
            contratanteRepository.salva(contrato.getContratante());
        }
        testemunhaRepository.salva(contrato.getTestemunhas());
        contratoRepository.cria(contrato);
        log.info("[finaliza] ContratoApplicationService - postContrato");
        return contrato;
    }

    @Override
    public Contrato getContratoById(Long idContrato) {
        log.info("[inicia] ContratoApplicationService - getContratoById");
        Contrato optionalContrato = contratoRepository.getContratoById(idContrato);
        log.info("[finaliza] ContratoApplicationService - getContratoById");
        return optionalContrato;
    }
}
