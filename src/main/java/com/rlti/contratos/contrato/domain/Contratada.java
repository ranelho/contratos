package com.rlti.contratos.contrato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.contratos.contrato.application.api.contratada.ContratadaRequest;
import com.rlti.contratos.contrato.domain.groups.PessoaJuridica;
import com.rlti.contratos.contrato.domain.groups.ContratadaGroupSequenceProvider;
import com.rlti.contratos.contrato.domain.groups.PessoaFisica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@GroupSequenceProvider(value = ContratadaGroupSequenceProvider.class)
public class Contratada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContratada;
    private String razaoSocialContratada;
    @NotNull(message = "Nome é Obrigatório!")
    private String nome;

    @NotNull(message = "Tipo pessoa é obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @NotBlank(message = "Cpf/Cnpj Obrigatório!")
    @CPF(groups = PessoaFisica.class)
    @CNPJ(groups = PessoaJuridica.class)
    @Column(name =  "cpf_cnpj", unique = true, updatable = false)
    private String cpfOuCnpj;

    private String enderecoContratada;
    private String cidadeContratada;
    private String cepContratada;
    private String estadoContratada;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contratada")
    @JsonIgnore
    private List<Contrato> contratos;

    public Contratada(ContratadaRequest contratadaRequest) {
        this.razaoSocialContratada = contratadaRequest.getRazaoSocialContratada();
        this.nome = contratadaRequest.getNome();
        this.tipoPessoa = contratadaRequest.getTipoPessoa();
        this.cpfOuCnpj = contratadaRequest.getCpfOuCnpj();
        this.enderecoContratada = contratadaRequest.getEnderecoContratada();
        this.cidadeContratada = contratadaRequest.getCidadeContratada();
        this.cepContratada = contratadaRequest.getCepContratada();
        this.estadoContratada = contratadaRequest.getEstadoContratada();
    }

    public void altera(ContratadaRequest request) {
        this.razaoSocialContratada = request.getRazaoSocialContratada();
        this.nome = request.getNome();
        this.enderecoContratada = request.getEnderecoContratada();
        this.cidadeContratada = request.getCidadeContratada();
        this.cepContratada = request.getCepContratada();
        this.estadoContratada = request.getEstadoContratada();
    }
}