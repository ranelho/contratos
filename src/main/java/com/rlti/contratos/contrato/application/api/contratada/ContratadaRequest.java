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
    @NotNull(message = "Endereço Obrigatório!")
    private String enderecoContratada;
    @NotNull(message = "Cidade Obrigatória!")
    private String cidadeContratada;
    @NotNull(message = "Cep Obrigatório!")
    private String cepContratada;
    @NotNull(message = "Estado Obrigatório!")
    private String estadoContratada;
}