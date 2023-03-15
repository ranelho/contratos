package com.rlti.contratos.contrato.domain;

import com.rlti.contratos.contratada.domain.Contratada;
import com.rlti.contratos.contratante.domain.Contratante;
import com.rlti.contratos.contrato.application.api.ContratoRequest;
import com.rlti.contratos.testemunha.domain.Testemunha;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    private int prazo;
    private LocalDate fimContrato;
    @ManyToOne
    private Testemunha testemunha1 ;
    @ManyToOne
    private Testemunha testemunha2 ;

    public Contrato(ContratoRequest contratoRequest, Contratada contratada , Contratante contratante,
                    Testemunha testemunha1, Testemunha testemunha2) {
        this.contratante = contratante;
        this.contratada = contratada;
        this.dataInicioContrato = contratoRequest.getDataInicioContrato();
        this.prazo = contratoRequest.getPrazo();
        this.fimContrato = calculoPrazo(contratoRequest.getPrazo(), contratoRequest.getDataInicioContrato());
        this.testemunha1 =  testemunha1;
        this.testemunha2 = testemunha2;
    }

    private LocalDate calculoPrazo(int prazo, LocalDate dataInicioContrato) {
        return fimContrato = dataInicioContrato.plusMonths((prazo));
    }


}