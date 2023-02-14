package com.rlti.contratos.contrato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.contratos.contrato.application.api.testemunha.TestemunhaRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Testemunha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTestemunhas;
    @NotBlank(message = "Nome é obrigatório!")
    private String nome;
    @CPF(message="cpf inválido")
    private String cpf;

    @OneToMany
    @JsonIgnore
    private List<Contrato> contratos;

    public Testemunha(TestemunhaRequest testemunhaRequest) {
        this.nome = testemunhaRequest.getNome();
        this.cpf = testemunhaRequest.getCpf();
    }

    public Testemunha(List<TestemunhaRequest> testemunhaRequestList) {
        for (TestemunhaRequest testemunhaRequest : testemunhaRequestList) {
            this.nome = testemunhaRequest.getNome();
            this.cpf = testemunhaRequest.getCpf();
        }
    }

    public void altera(TestemunhaRequest testemunhaRequest) {
        this.nome = testemunhaRequest.getNome();
    }
}