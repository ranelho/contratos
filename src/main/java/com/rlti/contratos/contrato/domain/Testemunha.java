package com.rlti.contratos.contrato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.contratos.contrato.application.api.testemunha.TestemunhaRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Testemunha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTestemunhas;
    private String nome;
    @CPF(message = "cpf inválido")
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "contrato_contrato_id")
    @JsonIgnore
    private Contrato contrato;

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