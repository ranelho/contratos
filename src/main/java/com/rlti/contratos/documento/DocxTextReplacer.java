package com.rlti.contratos.documento;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import com.rlti.contratos.contrato.application.api.ContratoResponse;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class DocxTextReplacer {

    /*  public String replaceText(ContratoResponse response) throws IOException {
          String filePath = Objects.requireNonNull(getClass().getClassLoader()
                          .getResource("contrato.docx"))
                  .getPath();
          try (InputStream inputStream = new FileInputStream(filePath)) {
              XWPFDocument doc = new XWPFDocument(inputStream);
              addDados(response, doc);
              saveFile(filePath, doc);
              doc.close();
          }
          return "ok";
      }*/

    public byte[] replaceText(ContratoResponse response) throws IOException {
        String filePath = Objects.requireNonNull(getClass().getClassLoader().getResource("contrato.docx")).getPath();
        try (InputStream inputStream = new FileInputStream(filePath);
             XWPFDocument doc = new XWPFDocument(inputStream);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
             substituirDados(response, doc);
             doc.write(baos);
             return baos.toByteArray();
        }
    }

    private void substituirDados(ContratoResponse response, XWPFDocument doc) {
        replaceText(doc, "{{numero_contrato}}", response.getNumeroContrato().toString());
        replaceText(doc, "{{CONTRATADA_RAZAOSOCIAL}}", response.getContratada().getNome().toUpperCase());
        replaceText(doc, "{{CNPJ_CONTRATADA}}", response.getContratada().getCpfCnpj());
        replaceText(doc, "{{ENDERECO_COMPLETO_COM_NUMERO_CONTRATADA}}", response.getContratada().getEnderecoContratada());
        replaceText(doc, "{{CIDADE_CONTRATADA}}", response.getContratada().getCidadeContratada());
        replaceText(doc, "{{ESTADO_CONTRATADA}}", response.getContratada().getEstadoContratada());
        replaceText(doc, "{{CEP_CONTRATADA}}", response.getContratada().getCepContratada());
        replaceText(doc, "{{CNPJ_CONTRATADA}}", response.getContratada().getCpfCnpj());
        replaceText(doc, "{{NOME_FANTASIA_CONTRATADA}}", response.getContratada().getRazaoSocialContratada().toUpperCase());

        replaceText(doc, "{{RAZAO_SOCIAL_CONTRATANTE}}", (response.getContratante().getRazaoSocialContratante() != null)
                ? response.getContratante().getRazaoSocialContratante().toUpperCase() : response.getContratante().getNome().toUpperCase());
        replaceText(doc, "{{CNPJ_CONTRATANTE}}", response.getContratante().getCpfCnpj());
        replaceText(doc, "{{ENDERECO_COMPLETO_COM_NUMERO_CONTRATANTE}}", response.getContratante().getEnderecoContratante());
        replaceText(doc, "{{CIDADE_CONTRATANTE}}", response.getContratante().getCidadeContratante());
        replaceText(doc, "{{CEP_CONTRATANTE}}", response.getContratante().getCepContratante());
        replaceText(doc, "{{ESTADO_CONTRATANTE}}", response.getContratante().getEstadoContratante());
        replaceText(doc, "{{NOME_FANTASIA}}", (response.getContratante().getRazaoSocialContratante() != null)
                ? response.getContratante().getRazaoSocialContratante().toUpperCase() : response.getContratante().getNome().toUpperCase());
        replaceText(doc, "{{NOME_FANTASIA_CONTRATANTE}}", (response.getContratante().getRazaoSocialContratante() != null)
                ? response.getContratante().getRazaoSocialContratante().toUpperCase() : response.getContratante().getNome().toUpperCase());

        replaceText(doc, "{{data_inicio_contrato}}", response.getDataInicioContrato().toString());

        replaceText(doc, "{{NOME_TESTEMUNHA1}}", response.getT1().getNome());
        replaceText(doc, "{{CPF_TESTEMUNHA1}}", response.getT1().getCpf());

        replaceText(doc, "{{NOME_TESTEMUNHA2}}", response.getT2().getNome());
        replaceText(doc, "{{CPF_TESTEMUNHA2}}", response.getT2().getCpf());
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

    public byte[] convertDocxToPdf(byte[] docxBytes) throws IOException {
        try (InputStream inputStream = new ByteArrayInputStream(docxBytes);
             XWPFDocument docx = new XWPFDocument(inputStream);
             ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream()) {

            PdfWriter writer = new PdfWriter(pdfOutputStream);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Configurações adicionais, como tamanho de página e margens
            pdf.setDefaultPageSize(new PageSize(PageSize.A4));

            for (XWPFParagraph para : docx.getParagraphs()) {
                for (XWPFRun run : para.getRuns()) {
                    document.add(new Paragraph(run.text()));
                }
            }

            document.close();
            pdf.close();

            return pdfOutputStream.toByteArray();
        }
    }

}
