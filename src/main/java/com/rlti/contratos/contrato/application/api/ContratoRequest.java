package com.rlti.contratos.contrato.application.api;

import com.rlti.contratos.contratada.application.api.ContratadaRequest;
import com.rlti.contratos.contratante.application.api.ContratanteRequest;
import com.rlti.contratos.testemunha.application.api.TestemunhaRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ContratoRequest {
    private ContratanteRequest contratanteRequest;
    private ContratadaRequest contratadaRequest;
    @NotNull(message = "Data Inicio Contrato Obrigatória!")
    private LocalDate dataInicioContrato;
    private int prazo;
    private TestemunhaRequest testemunha1;
    private TestemunhaRequest testemunha2;
}