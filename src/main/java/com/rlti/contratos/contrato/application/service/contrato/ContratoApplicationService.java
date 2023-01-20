package com.rlti.contratos.contrato.application.service.contrato;

import com.rlti.contratos.contrato.application.api.contrato.ContratoRequest;
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
    public Contrato postContratoSemCadastro(ContratoRequest contratoRequest) {
        log.info("[inicia] ContratoApplicationService - postContrato");
        Optional<Contratada> optionalContratada = contratadaRepository.findByCnpj(contratoRequest.getContratada().getCnpjContratada());
        Optional<Contratante> optionalContratante = contratanteRepository.findByCnpj(contratoRequest.getContratante().getCnpjContratante());
        final Contratada[] contratada = new Contratada[1];
        final Contratante[] contratante = new Contratante[1];
        optionalContratada.ifPresentOrElse(
                (value) -> { contratada[0] = optionalContratada.get();        },
                ()     -> {
                    contratada[0] = new Contratada(contratoRequest.getContratada());
                    contratadaRepository.salva(contratada[0]);
                }
        );
        optionalContratante.ifPresentOrElse(
                (value) -> { contratante[0] = optionalContratante.get();        },
                ()     -> {
                    contratante[0] = new Contratante(contratoRequest.getContratante());
                    contratanteRepository.salva(contratante[0]);
                }
        );
        Contrato contrato = new Contrato(contratoRequest, contratada[0], contratante[0]);
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
