package com.rlti.contratos.contrato.application.api.testemunha;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/testemunhas")
public interface TestemunhasApi {
    @PostMapping(value = "/cadastro")
    @ResponseStatus(code = HttpStatus.CREATED)
    TestemunhasResponse postTestemunhas(@Valid @RequestBody TestemunhasRequest testemunhasRequest);
}
