package com.rlti.contratos.testemunha.application.api;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class TestemunhaRequest {
    @NotBlank(message = "Nome é obrigatório!")
    private String nome;
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
    @NotBlank(message = "CPF é obrigatório!")
    private String cpf;
}