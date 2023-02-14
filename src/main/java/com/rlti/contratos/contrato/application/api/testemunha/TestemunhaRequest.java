package com.rlti.contratos.contrato.application.api.testemunha;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TestemunhaRequest {
    @NotBlank(message = "Nome é obrigatório!")
    private String nome;
    @NotBlank(message = "CPF é obrigatório!")
    private String cpf;
}