package com.rlti.contratos.contrato.application.api.contrato;

import com.rlti.contratos.contrato.application.api.contratada.ContratadaResponse;
import com.rlti.contratos.contrato.application.api.contratante.ContratanteResponse;
import com.rlti.contratos.contrato.application.api.testemunha.TestemunhasResponse;
import com.rlti.contratos.contrato.domain.Contrato;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ContratoResponse {
    private Long idContrato;
    private LocalDate dataInicioContrato;
    private ContratanteResponse contratanteResponse;
    private ContratadaResponse contratadaResponse;
    private TestemunhasResponse testemunhasResponses;

    public ContratoResponse(Contrato contrato) {
        this.idContrato = contrato.getIdContrato();
        this.dataInicioContrato = contrato.getDataInicioContrato();
        this.contratanteResponse = new ContratanteResponse(contrato.getContratante());
        this.contratadaResponse = new ContratadaResponse(contrato.getContratada());
        this.testemunhasResponses = new TestemunhasResponse(contrato.getTestemunhas());
    }
}