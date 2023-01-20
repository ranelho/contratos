package com.rlti.contratos.contrato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.contratos.contrato.application.api.contratada.ContratadaRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Contratada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContratada;
    private String razaoSocialContratada;
    @CNPJ(message = "CNPJ inválido")
    @Column(unique = true, updatable = true)
    private String cnpjContratada;
    private String enderecoContratada;
    private String cidadeContratada;
    private String cepContratada;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contratada")
    @JsonIgnore
    private List<Contrato> contratos;

    public Contratada(ContratadaRequest contratadaRequest) {
        this.razaoSocialContratada = contratadaRequest.getRazaoSocialContratada();
        this.cnpjContratada = contratadaRequest.getCnpjContratada();
        this.enderecoContratada = contratadaRequest.getEnderecoContratada();
        this.cidadeContratada = contratadaRequest.getCidadeContratada();
        this.cepContratada = contratadaRequest.getCepContratada();
    }
}
