package com.rlti.contratos.contrato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.contratos.contrato.application.api.testemunha.TestemunhasRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Testemunhas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTestemunhas;
    private String nomeTestemunha1;
    @CPF(message = "cpf inválido")
    private String cpfTestemunha1;
    private String nomeTestemunha2;
    @CPF(message = "cpf inválido")
    private String cpfTestemunha2;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;

    public Testemunhas(TestemunhasRequest testemunhasRequest) {
        this.nomeTestemunha1 = testemunhasRequest.getNomeTestemunha1();
        this.cpfTestemunha1 = testemunhasRequest.getCpfTestemunha1();
        this.nomeTestemunha2 = testemunhasRequest.getNomeTestemunha2();
        this.cpfTestemunha2 = testemunhasRequest.getCpfTestemunha2();
    }
}
