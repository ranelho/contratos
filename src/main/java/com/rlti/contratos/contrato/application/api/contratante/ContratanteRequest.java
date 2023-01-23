package com.rlti.contratos.contrato.application.api.contratante;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class ContratanteRequest {
    @NotNull(message = "Ração Social Obrigratória!")
    private String razaoSocialContratante;
    @NotNull(message = "Nome Fantasia Obrigatório!")
    private String nomeFantasiaContratante;
    @NotNull(message = "Cnpj Obrigatório!")
    private String cnpjContratante;
    @NotNull(message = "Endereço Obrigatório!")
    private String enderecoContratante;
    @NotNull(message = "Cidade Obrigatória!")
    private String cidadeContratante;
    @NotNull(message = "Cep Obrigatório!")
    private String cepContratante;
    @NotNull(message = "Estado Obrigatório!")
    private String estadoContratante;
}