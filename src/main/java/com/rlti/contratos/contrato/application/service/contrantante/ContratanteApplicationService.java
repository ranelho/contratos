package com.rlti.contratos.contrato.application.service.contrantante;

import com.rlti.contratos.contrato.application.api.contratante.ContratanteRequest;
import com.rlti.contratos.contrato.application.api.contratante.ContratanteResponse;
import com.rlti.contratos.contrato.application.repository.ContratanteRepository;
import com.rlti.contratos.contrato.domain.Contratante;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log4j2
public class ContratanteApplicationService implements ContratanteService {
    private final ContratanteRepository contratanteRepository;
    Contratante contratante = new Contratante();

    @Override
    public ContratanteResponse criaContratante(ContratanteRequest contratanteRequest) {
        log.info("[inicia] ContratanteApplicationService - criaContratante");
        contratante = contratanteRepository.salva(new Contratante(contratanteRequest));
        log.info("[finaliza] ContratanteApplicationService - criaContratante");
        return new ContratanteResponse(contratante);
    }

    @Override
    public Contratante alteraContratante(ContratanteRequest request) {
        log.info("[inicia] ContratanteApplicationService - alteraContratante");
        Optional<Contratante> optionalContratante = contratanteRepository.findByCnpj(request.getCnpjContratante());
        contratante = optionalContratante.orElseGet(() -> contratanteRepository.salva(new Contratante(request)));
        if (!contratante.getRazaoSocialContratante().equals(request.getRazaoSocialContratante())
                || !contratante.getNomeFantasiaContratante().equals(request.getNomeFantasiaContratante())) {
            contratante.altera(request);
            contratanteRepository.salva(contratante);
        }
        log.info("[finaliza] ContratanteApplicationService - alteraContratante");
        return contratante;
    }
}