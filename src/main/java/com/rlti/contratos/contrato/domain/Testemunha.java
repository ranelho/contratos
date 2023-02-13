package com.rlti.contratos.contrato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.contratos.contrato.application.api.testemunha.TestemunhaRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;

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

    @ManyToMany(mappedBy="testemunhas", cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;

    public Testemunha(TestemunhaRequest testemunhaRequest) {
        this.nome = testemunhaRequest.getNome();
        this.cpf = testemunhaRequest.getCpf();
    }
}