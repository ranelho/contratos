package com.rlti.contratos.contrato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.contratos.contrato.application.api.contratante.ContratanteRequest;
import com.rlti.contratos.contrato.domain.groups.CnpjGroup;
import com.rlti.contratos.contrato.domain.groups.ContratanteGroupSequenceProvider;
import com.rlti.contratos.contrato.domain.groups.CpfGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Setter
@Entity
@GroupSequenceProvider(value = ContratanteGroupSequenceProvider.class)
public class Contratante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContratante;
    private String razaoSocialContratante;

    @NotNull(message = "Nome Fantasia Obrigatório!")
    private String nome;

    @NotNull(message = "Tipo pessoa é obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @NotBlank(message = "Cpf/Cnpj Obrigatório!")
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    @Column(name =  "cpf_cnpj", unique = true, updatable = false)
    private String cpfOuCnpj;

    private String enderecoContratante;
    private String cidadeContratante;
    private String cepContratante;
    private String estadoContratante;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contratante")
    @JsonIgnore
    private List<Contrato> contratos;

    public Contratante(ContratanteRequest contratanteRequest) {
        this.razaoSocialContratante = contratanteRequest.getRazaoSocialContratante();
        this.nome = contratanteRequest.getNome();
        this.tipoPessoa = contratanteRequest.getTipoPessoa();
        this.cpfOuCnpj = contratanteRequest.getCpfOuCnpj();
        this.enderecoContratante = contratanteRequest.getEnderecoContratante();
        this.cidadeContratante = contratanteRequest.getCidadeContratante();
        this.cepContratante = contratanteRequest.getCepContratante();
        this.estadoContratante = contratanteRequest.getEstadoContratante();
    }

    public void altera(ContratanteRequest request) {
        this.razaoSocialContratante = request.getRazaoSocialContratante();
        this.nome = request.getNome();
        this.enderecoContratante = request.getEnderecoContratante();
        this.cidadeContratante = request.getCidadeContratante();
        this.cepContratante = request.getCepContratante();
        this.estadoContratante = request.getEstadoContratante();
    }
}
