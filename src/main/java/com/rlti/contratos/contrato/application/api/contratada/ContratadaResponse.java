package com.rlti.contratos.contrato.application.api.contratada;

import com.rlti.contratos.contrato.domain.Contratada;
import lombok.Value;

@Value
public class ContratadaResponse {
    private String razaoSocialContratada;
    private String nomeFantasiaContratada;
    private String cnpjContratada;
    private String enderecoContratada;
    private String cidadeContratada;
    private String cepContratada;
    private String estadoContratada;

    public ContratadaResponse(Contratada contratada) {
        this.razaoSocialContratada = contratada.getRazaoSocialContratada();
        this.nomeFantasiaContratada = contratada.getNomeFantasiaContratada();
        this.cnpjContratada = contratada.getCnpjContratada();
        this.enderecoContratada = contratada.getEnderecoContratada();
        this.cidadeContratada = contratada.getCidadeContratada();
        this.estadoContratada = contratada.getEstadoContratada();
        this.cepContratada = contratada.getCepContratada();
    }
}