package com.rlti.contratos.contrato.application.api.contratada;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/contratada")
public interface ContratadaApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ContratadaIdResponse postContratada(@Valid @RequestBody ContratadaRequest contratadaRequest);
}
