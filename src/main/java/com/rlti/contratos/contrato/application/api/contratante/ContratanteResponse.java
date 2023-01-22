package com.rlti.contratos.contrato.application.api.contratante;

import com.rlti.contratos.contrato.domain.Contratante;
import lombok.Value;

@Value
public class ContratanteResponse {
    private String razaoSocialContratante;
    private String nomeFantasiaContratante;
    private String cnpjContratante;
    private String enderecoContratante;
    private String cidadeContratante;
    private String cepContratante;
    private String estadoContratante;

    public ContratanteResponse(Contratante contratante) {
        this.razaoSocialContratante = contratante.getRazaoSocialContratante();
        this.nomeFantasiaContratante = contratante.getNomeFantasiaContratante();
        this.cnpjContratante = contratante.getCnpjContratante();
        this.enderecoContratante = contratante.getEnderecoContratante();
        this.cidadeContratante = contratante.getCidadeContratante();
        this.cepContratante = contratante.getCepContratante();
        this.estadoContratante = contratante.getEstadoContratante();
    }
}