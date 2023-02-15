package com.rlti.contratos.contratada.application.api;

import com.rlti.contratos.contrato.domain.TipoPessoa;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class ContratadaRequest {
    private String razaoSocialContratada;
    @NotNull(message = "Nome é Obrigatório!")
    private String nome;
    @NotNull(message = "Cnpj Obrigatório!")
    private TipoPessoa tipoPessoa;
    private String cpfOuCnpj;
    private String enderecoContratada;
    private String cidadeContratada;
    private String cepContratada;
    private String estadoContratada;
}