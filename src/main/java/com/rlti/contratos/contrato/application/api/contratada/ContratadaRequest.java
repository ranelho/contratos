package com.rlti.contratos.contrato.application.api.contratada;

import lombok.Value;

@Value
public class ContratadaRequest {
    private String razaoSocialContratada;
    private String cnpjContratada;
    private String enderecoContratada;
    private String cidadeContratada;
    private String cepContratada;
}