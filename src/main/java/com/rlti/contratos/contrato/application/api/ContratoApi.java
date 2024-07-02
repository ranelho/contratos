package com.rlti.contratos.contrato.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/v1/contrato")
public interface ContratoApi {

    @PostMapping(value = "/cadastro")
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<byte[]> novoContrato(@Valid @RequestBody ContratoRequest contratoRequest);

    @GetMapping(value = "/{idContrato}")
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<byte[]> getContratoById(@PathVariable Long idContrato);

    @DeleteMapping(value = "/{idContrato}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteContratoById(@PathVariable Long idContrato) ;
}