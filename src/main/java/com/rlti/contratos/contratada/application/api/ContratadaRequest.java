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
    @NotNull(message = "Campo Obrigatório!")
    TipoPessoa tipoPessoa;
    @Pattern(regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})$")
    String cpfOuCnpj;
    String enderecoContratada;
    String cidadeContratada;
    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$")
    String cepContratada;
    @Pattern(regexp = "^(AC|AL|AM|AP|BA|CE|DF|ES|GO|MA|MG|MS|MT|PA|PB|PE|PI|PR|RJ|RN|RO|RR|RS|SC|SE|SP|TO)$")
    String estadoContratada;
}