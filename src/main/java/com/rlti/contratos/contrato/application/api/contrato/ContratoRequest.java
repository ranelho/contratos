package com.rlti.contratos.contrato.application.api.contrato;

import com.rlti.contratos.contrato.domain.Contratada;
import com.rlti.contratos.contrato.domain.Contratante;
import com.rlti.contratos.contrato.domain.Testemunhas;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ContratoRequest {
    private Contratante contratante;
    private Contratada contratada;
    private LocalDate dataInicioContrato;
    private Testemunhas testemunhas;
}
