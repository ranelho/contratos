package com.rlti.contratos.contrato.application.api.contratante;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class ContratanteAlteracaoRequest {
    @NotNull(message = "Ração Social Obrigratória!")
    private String razaoSocialContratante;
    @NotNull(message = "Nome Fantasia Obrigatório!")
    private String nomeFantasiaContratante;
    private String enderecoContratante;
    private String cidadeContratante;
    private String cepContratante;
    private String estadoContratante;
}