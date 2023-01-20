package com.rlti.contratos.contrato.domain;

import com.rlti.contratos.contrato.application.api.contrato.ContratoRequest;
import com.rlti.contratos.contrato.application.api.contrato.ContratoRequestSemCadastro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contrato_id")
    private Long idContrato;
    @ManyToOne
    @JoinColumn(name = "contratante_id")
    private Contratante contratante;
    @ManyToOne
    @JoinColumn(name = "contratada_id")
    private Contratada contratada;
    private LocalDate dataInicioContrato;
    @OneToOne
    @JoinColumn(name = "testemunhas_id")
    private Testemunhas testemunhas;

    public Contrato(ContratoRequest contratoRequest) {
        this.contratante = contratoRequest.getContratante();
        this.contratada = contratoRequest.getContratada();
        this.dataInicioContrato = contratoRequest.getDataInicioContrato();
        this.testemunhas = contratoRequest.getTestemunhas();
    }
    public Contrato(ContratoRequestSemCadastro contratoRequestSemCadastro, Optional<Contratada> contratada , Optional<Contratante> contratante) {
        if (contratante.isPresent()) {
            this.contratante = contratante.get();
        } else {
            this.contratante = new Contratante(contratoRequestSemCadastro.getContratante());
        }
        if (contratada.isPresent()) {
            this.contratada = contratada.get();
        } else {
            this.contratada = new Contratada(contratoRequestSemCadastro.getContratada());
        }
        this.dataInicioContrato = contratoRequestSemCadastro.getDataInicioContrato();
        this.testemunhas = new Testemunhas(contratoRequestSemCadastro.getTestemunhas());
    }
}
