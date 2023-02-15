package com.rlti.contratos.contrato.application.service.contratada;

import com.rlti.contratos.contrato.application.api.contratada.ContratadaIdResponse;
import com.rlti.contratos.contrato.application.api.contratada.ContratadaRequest;
import com.rlti.contratos.contrato.application.repository.ContratadaRepository;
import com.rlti.contratos.contrato.domain.Contratada;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log4j2
public class ContratadaApplicationService implements ContratadaService {
    private final ContratadaRepository contratadaRepository;
    Contratada contratada = new Contratada();

    @Override
    public ContratadaIdResponse criaContratada(ContratadaRequest contratadaRequest) {
        log.info("[inicia] ContratadaApplicationService - criaContratada");
        Contratada contratada = contratadaRepository.salva(new Contratada(contratadaRequest));
        log.info("[finaliza] ContratadaApplicationService - criaContratada");
        return ContratadaIdResponse.builder().idContratada(contratada.getIdContratada()).build();
    }

    @Override
    public Contratada alteraContratada(ContratadaRequest request) {
        log.info("[inicia] ContratadaApplicationService - alteraContratada");
        Optional<Contratada> optionalContratada = contratadaRepository.findByCpfOrCnpj(request.getCpfOuCnpj());
        contratada = optionalContratada.orElseGet(() -> contratadaRepository.salva(new Contratada(request)));
        if(!contratada.getRazaoSocialContratada().equals(request.getCpfOuCnpj())
                || !contratada.getNome().equals(request.getNome())){
            contratada.altera(request);
            contratadaRepository.salva(contratada);
        }
        log.info("[finaliza] ContratadaApplicationService - alteraContratada");
        return contratada;
    }
}