package com.rlti.contratos.contratante.application.api;

import com.rlti.contratos.contrato.domain.TipoPessoa;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class ContratanteRequest {
    @NotNull(message = "Ração Social Obrigratória!")
    private String razaoSocialContratante;
    @NotNull(message = "Nome Fantasia Obrigatório!")
    private String nome;
    private TipoPessoa tipoPessoa;
    @NotNull(message = "Cnpj Obrigatório!")
    private String cpfOuCnpj;
    private String enderecoContratante;
    private String cidadeContratante;
    private String cepContratante;
    private String estadoContratante;
}