package com.rlti.contratos.contratada.application.api;

import com.rlti.contratos.contrato.application.api.ContratoListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/contratada")
public interface ContratadaApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ContratadaIdResponse postContratada(@Valid @RequestBody ContratadaRequest contratadaRequest);

    @GetMapping("/all-contratos/{cpfOrCnpj}")
    @ResponseStatus(code = HttpStatus.OK)
    List<ContratoListResponse> allContratos(@PathVariable String cpfOrCnpj);
}
