package com.rlti.contratos.contrato.application.api.contratante;

import lombok.Value;

@Value
public class ContratanteRequest {
    private String razaoSocialContratante;
    private String nomeFantasiaContratante;
    private String cnpjContratante;
    private String enderecoContratante;
    private String cidadeContratante;
    private String cepContratante;
    private String estadoContratante;
}