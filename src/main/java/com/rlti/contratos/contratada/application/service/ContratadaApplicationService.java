package com.rlti.contratos.contratada.application.service;

import com.rlti.contratos.contratada.application.api.ContratadaIdResponse;
import com.rlti.contratos.contratada.application.api.ContratadaRequest;
import com.rlti.contratos.contratada.application.repository.ContratadaRepository;
import com.rlti.contratos.contratada.domain.Contratada;
import com.rlti.contratos.contrato.application.api.ContratoListResponse;
import com.rlti.contratos.contrato.application.repository.ContratoRepository;
import com.rlti.contratos.contrato.domain.Contrato;
import com.rlti.contratos.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log4j2
public class ContratadaApplicationService implements ContratadaService {
    private final ContratadaRepository contratadaRepository;
    private final ContratoRepository contratoRepository;
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
        Optional<Contratada> optionalContratada = contratadaRepository.findByCpfOrCnpj(request.getCpfCnpj());
        contratada = optionalContratada.orElseGet(() -> contratadaRepository.salva(new Contratada(request)));
        if(!contratada.getRazaoSocialContratada().equals(request.getCpfCnpj())
                || !contratada.getNome().equals(request.getNome())){
            contratada.altera(request);
            contratadaRepository.salva(contratada);
        }
        log.info("[finaliza] ContratadaApplicationService - alteraContratada");
        return contratada;
    }

    @Override
    public List<ContratoListResponse> allContratos(String cpfOrCnpj) {
        log.info("[inicia] ContratadaApplicationService - allContratos");
        Long idContratada = contratadaRepository.findByCpfOrCnpj(cpfOrCnpj).orElseThrow(
                () -> {
                    throw APIException.build(HttpStatus.NOT_FOUND, "Cpf/Cnpj:" + cpfOrCnpj +" não localizado");
                })
                .getIdContratada();
        List<Contrato> contratadaList = contratoRepository.allContratos(idContratada);
        log.info("[finaliza] ContratadaApplicationService - allContratos");
        return ContratoListResponse.converte(contratadaList);
    }
}