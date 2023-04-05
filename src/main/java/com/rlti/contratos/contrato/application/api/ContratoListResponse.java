package com.rlti.contratos.contrato.application.api;

import com.rlti.contratos.contrato.domain.Contrato;
import com.rlti.contratos.handler.APIException;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ContratoListResponse {
    private Long idContrato;
    private LocalDate dataInicioContrato;
    private String nomeContratante;
    private String cpfOuCnpjContratante;
    private String nomeContratada;
    private String cpfOuCnpjContratada;


    public ContratoListResponse(Contrato contrato) {
        this.idContrato = contrato.getIdContrato();
        this.dataInicioContrato = contrato.getDataInicioContrato();
        this.nomeContratante = contrato.getContratante().getNome();
        this.cpfOuCnpjContratante = contrato.getContratante().getCpfCnpj();
        this.nomeContratada = contrato.getContratada().getNome();
        this.cpfOuCnpjContratada = contrato.getContratada().getCpfCnpj();
    }

    public static List<ContratoListResponse> converte(List<Contrato> contratadaList) {
        if(contratadaList.isEmpty()){
            throw APIException.build(HttpStatus.NOT_FOUND, "Sem contratos!");
        }else {
            return contratadaList.stream()
                    .map(ContratoListResponse::new)
                    .collect(Collectors.toList());
        }
    }
}