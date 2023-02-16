package com.rlti.contratos.contrato.application.api;

import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/contrato")
public interface ContratoApi {

    @PostMapping(value = "/cadastro")
    @ResponseStatus(code = HttpStatus.CREATED)
    ContratoResponse postContratoSemCadastro(@Valid @RequestBody ContratoRequest contratoRequest);

    @GetMapping(value = "/{idContrato}")
    @ResponseStatus(code = HttpStatus.OK)
    ContratoResponse getContratoById(@PathVariable Long idContrato);

    @DeleteMapping(value = "/{idContrato}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteContratoById(@PathVariable Long idContrato) ;
}