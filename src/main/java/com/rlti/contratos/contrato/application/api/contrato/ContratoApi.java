package com.rlti.contratos.contrato.application.api.contrato;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/contrato")
public interface ContratoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ContratoResponse postContrato(@Valid @RequestBody ContratoRequest contratoRequest);

    @PostMapping(value = "/sem-cadastro")
    @ResponseStatus(code = HttpStatus.CREATED)
    ContratoResponse postContratoSemCadastro(@Valid @RequestBody ContratoRequestSemCadastro contratoRequestSemCadastro);

    @GetMapping(value = "/{idContrato}")
    @ResponseStatus(code = HttpStatus.OK)
    ContratoResponse getContratoById(@PathVariable Long idContrato);
}