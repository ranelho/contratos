package com.rlti.contratos.contratante.application.api;

import com.rlti.contratos.contrato.domain.TipoPessoa;
import com.rlti.contratos.contrato.domain.groups.PessoaFisica;
import com.rlti.contratos.contrato.domain.groups.PessoaJuridica;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Value
public class ContratanteRequest {
    @NotNull(message = "Ração Social Obrigratória!")
    String razaoSocialContratante;
    @NotNull(message = "Nome Fantasia Obrigatório!")
    String nome;
    TipoPessoa tipoPessoa;
    @NotNull(message = "Campo Obrigatório!")
    @Pattern(regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})$")
    @CPF(groups = PessoaFisica.class, message = "CPF inválido!")
    @CNPJ(groups = PessoaJuridica.class, message = "CNPJ inválido!")
    String cpfCnpj;
    String enderecoContratante;
    String cidadeContratante;
    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$")
    String cepContratante;
    @Pattern(regexp = "^(AC|AL|AM|AP|BA|CE|DF|ES|GO|MA|MG|MS|MT|PA|PB|PE|PI|PR|RJ|RN|RO|RR|RS|SC|SE|SP|TO)$")
    String estadoContratante;
}