package com.rlti.contratos.contrato.application.api.testemunha;

import com.rlti.contratos.contrato.domain.Testemunha;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class TestemunhaResponse {
    private String nome;
    private String cpf;


    public TestemunhaResponse(Testemunha testemunhas) {
        this.nome = testemunhas.getNome();
        this.cpf = testemunhas.getCpf();
    }

    public static List<TestemunhaResponse> converte(List<Testemunha> testemunhas) {
            return testemunhas.stream()
                    .map(TestemunhaResponse::new)
                    .collect(Collectors.toList());
    }
}