package com.rlti.contratos.contrato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.contratos.contrato.application.api.contratante.ContratanteRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
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
    @Column(unique = true, updatable = true)
    private String cnpjContratante;
    @NotNull(message = "Endereço Obrigatório!")
    private String enderecoContratante;
    @NotNull(message = "Cidade Obrigatória!")
    private String cidadeContratante;
    @NotNull(message = "Cep Obrigatório!")
    private String cepContratante;
    @NotNull(message = "Estado Obrigatório!")
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
}
