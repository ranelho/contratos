package com.rlti.contratos.testemunha.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/testemunhas")
public interface TestemunhaApi {
    @PostMapping(value = "/cadastro")
    @ResponseStatus(code = HttpStatus.CREATED)
    TestemunhaResponse postTestemunhas(@Valid @RequestBody TestemunhaRequest testemunhaRequest);
}
