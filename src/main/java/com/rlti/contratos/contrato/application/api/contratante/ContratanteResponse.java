package com.rlti.contratos.contrato.application.api.contratante;

import com.rlti.contratos.contrato.domain.Contratante;
import lombok.Value;

@Value
public class ContratanteResponse {
    private String razaoSocialContratante;
    private String cnpjContratante;
    private String enderecoContratante;
    private String cidadeContratante;
    private String cepContratante;

    public ContratanteResponse(Contratante contratante) {
        this.razaoSocialContratante = contratante.getRazaoSocialContratante();
        this.cnpjContratante = contratante.getCnpjContratante();
        this.enderecoContratante = contratante.getEnderecoContratante();
        this.cidadeContratante = contratante.getCidadeContratante();
        this.cepContratante = contratante.getCepContratante();
    }
}