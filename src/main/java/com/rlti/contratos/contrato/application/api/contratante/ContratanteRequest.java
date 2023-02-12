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
    private String enderecoContratante;
    private String cidadeContratante;
    private String cepContratante;
    private String estadoContratante;
}