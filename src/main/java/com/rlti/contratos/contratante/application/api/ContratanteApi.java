package com.rlti.contratos.contratante.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/contratante")
public interface ContratanteApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ContratanteResponse postContratante(@Valid @RequestBody ContratanteRequest contratanteRequest);
}