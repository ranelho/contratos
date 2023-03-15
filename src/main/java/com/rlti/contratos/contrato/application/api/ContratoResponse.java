package com.rlti.contratos.contrato.application.api;

import com.rlti.contratos.contratada.application.api.ContratadaResponse;
import com.rlti.contratos.contratante.application.api.ContratanteResponse;
import com.rlti.contratos.testemunha.application.api.TestemunhaResponse;
import com.rlti.contratos.contrato.domain.Contrato;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ContratoResponse {
    private Long idContrato;
    private LocalDate dataInicioContrato;
    private LocalDate fimContrato;
    private ContratanteResponse contratanteResponse;
    private ContratadaResponse contratadaResponse;
    private TestemunhaResponse testemunha1;
    private TestemunhaResponse testemunha2;

    public ContratoResponse(Contrato contrato) {
        this.idContrato = contrato.getIdContrato();
        this.dataInicioContrato = contrato.getDataInicioContrato();
        this.fimContrato = contrato.getFimContrato();
        this.contratanteResponse = new ContratanteResponse(contrato.getContratante());
        this.contratadaResponse = new ContratadaResponse(contrato.getContratada());
        this.testemunha1 = new TestemunhaResponse(contrato.getTestemunha1());
        this.testemunha2 = new TestemunhaResponse(contrato.getTestemunha2());
    }
}