package com.rlti.contratos.contratada.application.api;

import com.rlti.contratos.contrato.domain.TipoPessoa;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Value
public class ContratadaRequest {
    String razaoSocialContratada;
    @NotNull(message = "Nome é Obrigatório!")
    String nome;
    @NotNull(message = "Cnpj Obrigatório!")
    TipoPessoa tipoPessoa;
    @Pattern(regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})$")
    String cpfOuCnpj;
    String enderecoContratada;
    String cidadeContratada;
    String cepContratada;
    String estadoContratada;
}