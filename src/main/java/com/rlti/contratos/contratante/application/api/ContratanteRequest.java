package com.rlti.contratos.contratante.application.api;

import com.rlti.contratos.contrato.domain.TipoPessoa;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Value
public class ContratanteRequest {
    @NotNull(message = "Ração Social Obrigratória!")
    String razaoSocialContratante;
    @NotNull(message = "Nome Fantasia Obrigatório!")
    String nome;
    TipoPessoa tipoPessoa;
    @NotNull(message = "Cnpj Obrigatório!")
    @Pattern(regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})$")
    String cpfOuCnpj;
    String enderecoContratante;
    String cidadeContratante;
    String cepContratante;
    String estadoContratante;
}