package com.rlti.contratos.testemunha.application.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Value
public class TestemunhaRequest {
    @NotBlank(message = "Nome é obrigatório!")
    String nome;
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
    @NotBlank(message = "CPF é obrigatório!")
    String cpf;
}