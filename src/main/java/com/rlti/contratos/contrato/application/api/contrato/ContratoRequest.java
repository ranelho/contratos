package com.rlti.contratos.contrato.application.api.contrato;

import com.rlti.contratos.contrato.application.api.contratada.ContratadaRequest;
import com.rlti.contratos.contrato.application.api.contratante.ContratanteRequest;
import com.rlti.contratos.contrato.application.api.testemunha.TestemunhaRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ContratoRequest {
    private ContratanteRequest contratanteRequest;
    private ContratadaRequest contratadaRequest;
    @NotNull(message = "Data Inicio Contrato Obrigatória!")
    private LocalDate dataInicioContrato;
    private TestemunhaRequest testemunha1;
    private TestemunhaRequest testemunha2;
}