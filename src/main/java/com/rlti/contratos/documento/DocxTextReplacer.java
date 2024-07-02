package com.rlti.contratos.documento;

import com.rlti.contratos.contrato.application.api.ContratoResponse;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class DocxTextReplacer {

    public String replaceText(ContratoResponse response) throws IOException {
        String filePath = Objects.requireNonNull(getClass().getClassLoader()
                        .getResource("contrato.docx"))
                .getPath();
        try (InputStream inputStream = new FileInputStream(filePath)) {
            XWPFDocument doc = new XWPFDocument(inputStream);
            replaceText(doc, "{{numero_contrato}}", response.getIdContrato().toString());
            replaceText(doc, "{{CONTRATADA_RAZAOSOCIAL}}", response.getContratadaResponse().getNome().toUpperCase());
            replaceText(doc, "{{CNPJ_CONTRATADA}}", response.getContratadaResponse().getCpfCnpj());
            replaceText(doc, "{{ENDERECO_COMPLETO_COM_NUMERO_CONTRATADA}}", response.getContratadaResponse().getEnderecoContratada());
            replaceText(doc, "{{CIDADE_CONTRATADA}}", response.getContratadaResponse().getCidadeContratada());
            replaceText(doc, "{{ESTADO_CONTRATADA}}", response.getContratadaResponse().getEstadoContratada());
            replaceText(doc, "{{CEP_CONTRATADA}}", response.getContratadaResponse().getCepContratada());
            replaceText(doc, "{{CNPJ_CONTRATADA}}", response.getContratadaResponse().getCpfCnpj());
            replaceText(doc, "{{NOME_FANTASIA_CONTRATADA}}", response.getContratadaResponse().getRazaoSocialContratada().toUpperCase());

            saveFile(filePath, doc);
            doc.close();
        }
        return "ok";
    }

    private void replaceText(XWPFDocument doc, String originalText, String updatedText) {
        replaceTextInParagraphs(doc.getParagraphs(), originalText, updatedText);
        for (XWPFTable tbl : doc.getTables()) {
            for (XWPFTableRow row : tbl.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    replaceTextInParagraphs(cell.getParagraphs(), originalText, updatedText);
                }
            }
        }
    }

    private void replaceTextInParagraphs(List<XWPFParagraph> paragraphs, String originalText, String updatedText) {
        paragraphs.forEach(paragraph -> replaceTextInParagraph(paragraph, originalText, updatedText));
    }

    private void replaceTextInParagraph(XWPFParagraph paragraph, String originalText, String updatedText) {
        String paragraphText = paragraph.getParagraphText();
        if (paragraphText.contains(originalText)) {
            String updatedParagraphText = paragraphText.replace(originalText, updatedText);
            while (!paragraph.getRuns().isEmpty()) {
                paragraph.removeRun(0);
            }
            XWPFRun newRun = paragraph.createRun();
            newRun.setText(updatedParagraphText);
        }
    }

    private void saveFile(String filePath, XWPFDocument doc) throws IOException {
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            doc.write(out);
        }
    }

   
}
