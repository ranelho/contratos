package com.rlti.contratos.contrato.application.api.testemunha;

import com.rlti.contratos.contrato.application.service.testemunhas.TestemunhaService;
import com.rlti.contratos.contrato.domain.Testemunha;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class TestemunhaRestController implements TestemunhaApi {
    private final TestemunhaService testemunhaService;

    @Override
    public TestemunhaResponse postTestemunhas(TestemunhaRequest testemunhaRequest) {
        log.info("[inicia] EquipamentoRestController - postEquipamento");
        Testemunha response = testemunhaService.criaTestemunhas(testemunhaRequest);
        log.info("[finaliza] EquipamentoRestController - postEquipamento");
        return new TestemunhaResponse(response);
    }
}
