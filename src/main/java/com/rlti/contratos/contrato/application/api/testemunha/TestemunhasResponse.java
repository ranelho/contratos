package com.rlti.contratos.contrato.application.api.testemunha;

import com.rlti.contratos.contrato.domain.Testemunhas;
import lombok.Value;

@Value
public class TestemunhasResponse {
    private String nomeTestemunha1;
    private String cpfTestemunha1;
    private String nomeTestemunha2;
    private String cpfTestemunha2;

    public TestemunhasResponse(Testemunhas testemunhas) {
        this.nomeTestemunha1 = testemunhas.getNomeTestemunha1();
        this.cpfTestemunha1 = testemunhas.getCpfTestemunha1();
        this.nomeTestemunha2 = testemunhas.getNomeTestemunha2();
        this.cpfTestemunha2 = testemunhas.getCpfTestemunha2();
    }
}