package com.rlti.contratos.contrato.application.api.contratada;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class ContratadaRequest {
    @NotNull(message = "Ração Social Obrigratória!")
    private String razaoSocialContratada;
    @NotNull(message = "Nome Fantasia Obrigatório!")
    private String nomeFantasiaContratada;
    @NotNull(message = "Cnpj Obrigatório!")
    private String cnpjContratada;
    private String enderecoContratada;
    private String cidadeContratada;
    private String cepContratada;
    private String estadoContratada;
}