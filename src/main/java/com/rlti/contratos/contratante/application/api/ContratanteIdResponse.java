package com.rlti.contratos.contratante.application.api;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ContratanteIdResponse {
    private Long idContratante;
}