package com.rlti.contratos.contrato.application.api;

import com.rlti.contratos.contratada.application.api.ContratadaResponse;
import com.rlti.contratos.contratante.application.api.ContratanteResponse;
import com.rlti.contratos.testemunha.application.api.TestemunhaResponse;
import com.rlti.contratos.contrato.domain.Contrato;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ContratoResponse {
    private Long numeroContrato;
    private LocalDate dataInicioContrato;
    private LocalDate fimContrato;
    private ContratanteResponse contratante;
    private ContratadaResponse contratada;
    private TestemunhaResponse t1;
    private TestemunhaResponse t2;

    public ContratoResponse(Contrato contrato) {
        this.numeroContrato = contrato.getIdContrato();
        this.dataInicioContrato = contrato.getDataInicioContrato();
        this.fimContrato = contrato.getFimContrato();
        this.contratante = new ContratanteResponse(contrato.getContratante());
        this.contratada = new ContratadaResponse(contrato.getContratada());
        this.t1 = new TestemunhaResponse(contrato.getTestemunha1());
        this.t2 = new TestemunhaResponse(contrato.getTestemunha2());
    }
}