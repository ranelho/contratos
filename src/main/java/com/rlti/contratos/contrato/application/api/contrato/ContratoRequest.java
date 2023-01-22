package com.rlti.contratos.contrato.application.api.contrato;

import com.rlti.contratos.contrato.application.api.contratada.ContratadaRequest;
import com.rlti.contratos.contrato.application.api.contratante.ContratanteRequest;
import com.rlti.contratos.contrato.application.api.testemunha.TestemunhasRequest;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ContratoRequest {
    private ContratanteRequest contratanteRequest;
    private ContratadaRequest contratadaRequest;
    private LocalDate dataInicioContrato;
    private TestemunhasRequest testemunhas;
}