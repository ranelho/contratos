package com.rlti.contratos.contrato.application.api;

import com.rlti.contratos.contrato.application.service.ContratoService;
import com.rlti.contratos.documento.DocxTextReplacer;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@Log4j2
public class ContratoRestController implements ContratoApi {
    private final ContratoService contratoService;
    private final DocxTextReplacer docxTextReplacer;

    @SneakyThrows
    @Override
    public ResponseEntity<byte[]>  novoContrato(ContratoRequest contratoRequest) {
        log.info("[inicia] ContratoController - postContrato");
        ContratoResponse contratoResponse = contratoService.novoContrato(contratoRequest);
        byte[] document = docxTextReplacer.replaceText(contratoResponse);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=contrato.docx");
        log.info("[finaliza] ContratoController - novoContrato");
        return new ResponseEntity<>(document, headers, HttpStatus.OK);
    }

    @SneakyThrows
    @Override
    public ResponseEntity<byte[]> getContratoById(Long idContrato) {
        log.info("[inicia] ContratoController - getContratoById");
        ContratoResponse contratoResponse = contratoService.getContratoById(idContrato);
        byte[] docxBytes  = docxTextReplacer.replaceText(contratoResponse);
     //   byte[] pdfBytes = docxTextReplacer.convertDocxToPdf(docxBytes);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=contrato.docx");
        return new ResponseEntity<>(docxBytes, headers, HttpStatus.OK);
    }

    @Override
    public void deleteContratoById(Long idContrato) {
        log.info("[inicia] ContratoController - deleteContratoById");
        contratoService.deleteContratoById(idContrato);
        log.info("[finaliza] ContratoController - deleteContratoById");
    }
}
