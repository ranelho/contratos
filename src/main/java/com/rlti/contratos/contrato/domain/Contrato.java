package com.rlti.contratos.contrato.domain;

import com.rlti.contratos.contrato.application.api.contrato.ContratoRequest;
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

    public Contrato(ContratoRequest contratoRequest, Contratada contratada , Contratante contratante) {
        this.contratante = contratante;
        this.contratada = contratada;
        this.dataInicioContrato = contratoRequest.getDataInicioContrato();
        this.testemunhas = new Testemunhas(contratoRequest.getTestemunhas());
    }
}
