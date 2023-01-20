package com.rlti.contratos.contrato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.contratos.contrato.application.api.contratante.ContratanteRequest;
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
public class Contratante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContratante;
    private String razaoSocialContratante;
    @CNPJ(message = "CNPJ inválido")
    @Column(unique = true, updatable = true)
    private String cnpjContratante;
    private String enderecoContratante;
    private String cidadeContratante;
    private String cepContratante;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contratante")
    @JsonIgnore
    private List<Contrato> contratos;

    public Contratante(ContratanteRequest contratanteRequest) {
        this.razaoSocialContratante = contratanteRequest.getRazaoSocialContratante();
        this.cnpjContratante = contratanteRequest.getCnpjContratante();
        this.enderecoContratante = contratanteRequest.getEnderecoContratante();
        this.cidadeContratante = contratanteRequest.getCidadeContratante();
        this.cepContratante = contratanteRequest.getCepContratante();
    }
}
