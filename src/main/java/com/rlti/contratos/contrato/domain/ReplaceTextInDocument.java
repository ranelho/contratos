package com.rlti.contratos.contrato.domain;

import com.rlti.contratos.contrato.application.api.contrato.ContratoResponse;
import com.spire.doc.Document;
import com.spire.doc.FileFormat;

public class ReplaceTextInDocument {

    /**
     *
     * @param contrato recebe contrato response com todos os dados necessários para validação do arquivo.
     */
    public static void upadate(ContratoResponse contrato) {
        String arquivo = "contrato.docx";

        Document document = new Document(arquivo);

        // Replace a specific text
        document.replace("{{numero_contrato}}", contrato.getIdContrato().toString(), false, true);

        document.replace("{{CONTRATADA_RAZAOSOCIAL}}", contrato.getContratadaResponse().getRazaoSocialContratada(), false, true);
        document.replace("{{CNPJ_CONTRATADA}}", contrato.getContratadaResponse().getCnpjContratada(), false, true);
        document.replace("{{CIDADE_CONTRATADA}}", contrato.getContratadaResponse().getCidadeContratada(), false, true);
        document.replace("{{ENDERECO_COMPLETO_COM_NUMERO_CONTRATADA}}", contrato.getContratadaResponse().getEnderecoContratada(), false, true);
        document.replace("{{CEP_CONTRATADA}}", contrato.getContratadaResponse().getCepContratada(), false, true);
        document.replace("{{ESTADO_CONTRATADA}}", contrato.getContratadaResponse().getEstadoContratada(), false, true);
        document.replace("{{NOME_FANTASIA_CONTRATADA}}", contrato.getContratadaResponse().getNomeFantasiaContratada(), false, true);
        
        document.replace("{{RAZAO_SOCIAL_CONTRATANTE}}", contrato.getContratanteResponse().getRazaoSocialContratante(), false, true);
        document.replace("{{CNPJ_CONTRATANTE}}", contrato.getContratanteResponse().getCnpjContratante(), false, true);
        document.replace("{{ENDERECO_COMPLETO_COM_NUMERO_CONTRATANTE}}", contrato.getContratanteResponse().getEnderecoContratante(), false, true);
        document.replace("{{CIDADE_CONTRATANTE}}", contrato.getContratanteResponse().getCidadeContratante(), false, true);
        document.replace("{{ESTADO_CONTRATANTE}}", contrato.getContratanteResponse().getEstadoContratante(), false, true);
        document.replace("{{CEP_CONTRATANTE}}", contrato.getContratanteResponse().getCepContratante(), false, true);
        document.replace("{{NOME_FANTASIA_CONTRATANTE}}", contrato.getContratanteResponse().getNomeFantasiaContratante(), false, true);

        document.replace("{{data_inicio_contrato}}", contrato.getDataInicioContrato().toString(), false, true);
        document.replace("{{NOME_TESTEMUNHA1}}", contrato.getTestemunhaResponses().getNomeTestemunha1(), false, true);
        document.replace("{{CPF_TESTEMUNHA1}}", contrato.getTestemunhaResponses().getCpfTestemunha1(), false, true);
        document.replace("{{NOME_TESTEMUNHA2}}", contrato.getTestemunhaResponses().getNomeTestemunha2(), false, true);
        document.replace("{{CPF_TESTEMUNHA2}}", contrato.getTestemunhaResponses().getCpfTestemunha2(), false, true);

        //Save the result document
        /**
         * para salvar o documento em pdf usar comando abaixo, ferramenta paga, so permite pdf em até 3 paginas
         */
        //document.saveToFile("NovoContrato.pdf", FileFormat.PDF);*/
        document.saveToFile("NovoContrato.docx", FileFormat.Docx);
    }
}
