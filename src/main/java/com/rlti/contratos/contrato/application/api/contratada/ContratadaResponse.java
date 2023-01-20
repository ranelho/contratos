package com.rlti.contratos.contrato.application.api.contratada;

import com.rlti.contratos.contrato.domain.Contratada;
import lombok.Value;

@Value
public class ContratadaResponse {
    private String razaoSocialContratada;
    private String cnpjContratada;
    private String enderecoContratada;
    private String cidadeContratada;
    private String cepContratada;

    public ContratadaResponse(Contratada contratada) {
        this.razaoSocialContratada = contratada.getRazaoSocialContratada();
        this.cnpjContratada = contratada.getCnpjContratada();
        this.enderecoContratada = contratada.getEnderecoContratada();
        this.cidadeContratada = contratada.getCidadeContratada();
        this.cepContratada = contratada.getCepContratada();
    }
}