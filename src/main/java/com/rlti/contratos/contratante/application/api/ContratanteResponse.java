package com.rlti.contratos.contratante.application.api;

import com.rlti.contratos.contratante.domain.Contratante;
import lombok.Value;

@Value
public class ContratanteResponse {
    private String razaoSocialContratante;
    private String nome;
    private String cpfCnpj;
    private String enderecoContratante;
    private String cidadeContratante;
    private String cepContratante;
    private String estadoContratante;

    public ContratanteResponse(Contratante contratante) {
        this.razaoSocialContratante = contratante.getRazaoSocialContratante();
        this.nome = contratante.getNome();
        this.cpfCnpj = contratante.getCpfCnpj();
        this.enderecoContratante = contratante.getEnderecoContratante();
        this.cidadeContratante = contratante.getCidadeContratante();
        this.cepContratante = contratante.getCepContratante();
        this.estadoContratante = contratante.getEstadoContratante();
    }
}