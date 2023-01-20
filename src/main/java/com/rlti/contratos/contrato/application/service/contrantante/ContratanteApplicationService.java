package com.rlti.contratos.contrato.application.service.contrantante;

import com.rlti.contratos.contrato.application.api.contratante.ContratanteIdResponse;
import com.rlti.contratos.contrato.application.api.contratante.ContratanteRequest;
import com.rlti.contratos.contrato.application.api.contratante.ContratanteResponse;
import com.rlti.contratos.contrato.application.repository.contratante.ContratanteRepository;
import com.rlti.contratos.contrato.domain.Contratante;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class ContratanteApplicationService implements ContratanteService {
    private final ContratanteRepository contratanteRepository;

    @Override
    public ContratanteResponse criaContratante(ContratanteRequest contratanteRequest) {
        log.info("[inicia] ContratanteApplicationService - criaContratante");
        Contratante contratante = contratanteRepository.salva(new Contratante(contratanteRequest));
        log.info("[finaliza] ContratanteApplicationService - criaContratante");
        return new ContratanteResponse(contratante);
    }
}