package com.rlti.contratos.contratada.application.service;

import com.rlti.contratos.contratante.application.api.ContratanteRequest;
import com.rlti.contratos.contratante.application.api.ContratanteResponse;
import com.rlti.contratos.contratante.application.repository.ContratanteRepository;
import com.rlti.contratos.contratante.domain.Contratante;
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
        Optional<Contratante> optionalContratante = contratanteRepository.findByCpfOrCnpj(request.getCpfOuCnpj());
        contratante = optionalContratante.orElseGet(() -> contratanteRepository.salva(new Contratante(request)));
        if (!contratante.getRazaoSocialContratante().equals(request.getRazaoSocialContratante())
                || !contratante.getNome().equals(request.getNome())) {
            contratante.altera(request);
            contratanteRepository.salva(contratante);
        }
        log.info("[finaliza] ContratanteApplicationService - alteraContratante");
        return contratante;
    }
}