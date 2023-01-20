package com.rlti.contratos.contrato.application.api.contrato;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ContratoIdResponse {
    private Long idContrato;
}