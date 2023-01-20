package com.rlti.contratos.contrato.application.api.contrato;

import com.rlti.contratos.contrato.application.api.contratada.ContratadaRequest;
import com.rlti.contratos.contrato.application.api.contratante.ContratanteRequest;
import com.rlti.contratos.contrato.application.api.testemunha.TestemunhasRequest;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ContratoRequestSemCadastro {
    private ContratanteRequest contratante;
    private ContratadaRequest contratada;
    private LocalDate dataInicioContrato;
    private TestemunhasRequest testemunhas;
}
