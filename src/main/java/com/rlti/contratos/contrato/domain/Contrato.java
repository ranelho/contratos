package com.rlti.contratos.contrato.domain;

import com.rlti.contratos.contrato.application.api.contrato.ContratoRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

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
    @NotNull(message = "Data Inicio Contrato Obrigatória!")
    private LocalDate dataInicioContrato;

    @ManyToOne
    @JoinColumn(name = "testemunha_1_id_testemunhas")
    private Testemunha testemunha1 ;
    @ManyToOne
    @JoinColumn(name = "testemunha_2_id_testemunhas")
    private Testemunha testemunha2 ;


    public Contrato(ContratoRequest contratoRequest, Contratada contratada , Contratante contratante, Testemunha testemunha1, Testemunha testemunha2) {
        this.contratante = contratante;
        this.contratada = contratada;
        this.dataInicioContrato = contratoRequest.getDataInicioContrato();
        this.testemunha1 =  testemunha1;
        this.testemunha2 = testemunha2;
    }
}