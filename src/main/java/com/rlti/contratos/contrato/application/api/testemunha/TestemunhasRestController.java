package com.rlti.contratos.contrato.application.api.testemunha;

import com.rlti.contratos.contrato.application.service.testemunhas.TestemunhasService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class TestemunhasRestController implements TestemunhasApi {
    private final TestemunhasService testemunhasService;

    @Override
    public TestemunhaResponse postTestemunhas(TestemunhasRequest testemunhasRequest) {
        log.info("[inicia] EquipamentoRestController - postEquipamento");
        TestemunhaResponse response = testemunhasService.criaTestemunhas(testemunhasRequest);
        log.info("[finaliza] EquipamentoRestController - postEquipamento");
        return response;
    }
}
