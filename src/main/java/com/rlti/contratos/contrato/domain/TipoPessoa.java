package com.rlti.contratos.contrato.domain;

import com.rlti.contratos.contrato.domain.groups.CpfGroup;
import lombok.Getter;

@Getter
public enum TipoPessoa {
    FISICA("Física", "CPF", "000.000.000-00", CpfGroup.class),
    JURIDICA("Jurídica", "CNPJ", "00.000.000/0000-00", CpfGroup.class);

    private final String descricao;
    private final String documento;
    private final String mascara;
    private final Class<?> group;

    TipoPessoa(String descricao, String documento, String mascara, Class<?> group) {
        this.descricao = descricao;
        this.documento = documento;
        this.mascara = mascara;
        this.group = group;
    }
}
