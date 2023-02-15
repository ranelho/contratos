package com.rlti.contratos.contratada.application.api;

import com.rlti.contratos.contratada.domain.Contratada;
import lombok.Value;

@Value
public class ContratadaResponse {
    private String razaoSocialContratada;
    private String nome;
    private String cpfOuCnpj;
    private String enderecoContratada;
    private String cidadeContratada;
    private String cepContratada;
    private String estadoContratada;

    public ContratadaResponse(Contratada contratada) {
        this.razaoSocialContratada = contratada.getRazaoSocialContratada();
        this.nome = contratada.getNome();
        this.cpfOuCnpj = contratada.getCpfOuCnpj();
        this.enderecoContratada = contratada.getEnderecoContratada();
        this.cidadeContratada = contratada.getCidadeContratada();
        this.estadoContratada = contratada.getEstadoContratada();
        this.cepContratada = contratada.getCepContratada();
    }
}