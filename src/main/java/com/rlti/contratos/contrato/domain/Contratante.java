package com.rlti.contratos.contrato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.contratos.contrato.application.api.contratante.ContratanteRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Contratante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContratante;
    @NotNull(message = "Ração Social Obrigratória!")
    private String razaoSocialContratante;
    @NotNull(message = "Nome Fantasia Obrigatório!")
    private String nomeFantasiaContratante;
    @CNPJ(message = "CNPJ inválido")
    @NotNull(message = "Cnpj Obrigatório!")
    @Column(unique = true, updatable = false)
    private String cnpjContratante;
    private String enderecoContratante;
    private String cidadeContratante;
    private String cepContratante;
    private String estadoContratante;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contratante")
    @JsonIgnore
    private List<Contrato> contratos;

    public Contratante(ContratanteRequest contratanteRequest) {
        this.razaoSocialContratante = contratanteRequest.getRazaoSocialContratante();
        this.nomeFantasiaContratante = contratanteRequest.getNomeFantasiaContratante();
        this.cnpjContratante = contratanteRequest.getCnpjContratante();
        this.enderecoContratante = contratanteRequest.getEnderecoContratante();
        this.cidadeContratante = contratanteRequest.getCidadeContratante();
        this.cepContratante = contratanteRequest.getCepContratante();
        this.estadoContratante = contratanteRequest.getEstadoContratante();
    }

    public void altera(ContratanteRequest request) {
        this.razaoSocialContratante = request.getRazaoSocialContratante();
        this.nomeFantasiaContratante = request.getNomeFantasiaContratante();
        this.enderecoContratante = request.getEnderecoContratante();
        this.cidadeContratante = request.getCidadeContratante();
        this.cepContratante = request.getCepContratante();
        this.estadoContratante = request.getEstadoContratante();
    }
}
