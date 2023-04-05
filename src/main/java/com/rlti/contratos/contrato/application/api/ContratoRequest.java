package com.rlti.contratos.contrato.application.api;

import com.rlti.contratos.contratada.application.api.ContratadaRequest;
import com.rlti.contratos.contratante.application.api.ContratanteRequest;
import com.rlti.contratos.testemunha.application.api.TestemunhaRequest;
import lombok.Data;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class ContratoRequest {
    @Valid
    ContratanteRequest contratanteRequest;
    @Valid
    ContratadaRequest contratadaRequest;
    @NotNull(message = "Data Inicio Contrato Obrigatória!")
    LocalDate dataInicioContrato;
    int prazo;
    TestemunhaRequest testemunha1;
    TestemunhaRequest testemunha2;
}