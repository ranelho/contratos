package com.rlti.contratos.contratada.application.service;

import com.rlti.contratos.contratante.application.api.ContratanteRequest;
import com.rlti.contratos.contratante.application.api.ContratanteResponse;
import com.rlti.contratos.contratante.application.repository.ContratanteRepository;
import com.rlti.contratos.contratante.application.service.ContratanteApplicationService;
import com.rlti.contratos.contratante.domain.Contratante;
import com.rlti.contratos.contrato.domain.TipoPessoa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ContratanteApplicationService.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ContratanteApplicationServiceTest {
    @Autowired
    private ContratanteApplicationService contratanteApplicationService;

    @MockBean
    private ContratanteRepository contratanteRepository;

    @Test
    void testCriaContratante() {
        Contratante contratante = new Contratante();
        contratante.setCepContratante("Cep Contratante");
        contratante.setCidadeContratante("Cidade Contratante");
        contratante.setContratos(new ArrayList<>());
        contratante.setCpfCnpj("Cpf Ou Cnpj");
        contratante.setEnderecoContratante("Endereco Contratante");
        contratante.setEstadoContratante("Estado Contratante");
        contratante.setIdContratante(1L);
        contratante.setNome("Nome");
        contratante.setRazaoSocialContratante("Razao Social Contratante");
        contratante.setTipoPessoa(TipoPessoa.FISICA);
        when(contratanteRepository.salva((Contratante) any())).thenReturn(contratante);
        ContratanteResponse actualCriaContratanteResult = contratanteApplicationService
                .criaContratante(new ContratanteRequest("Razao Social Contratante", "Nome", TipoPessoa.FISICA, "Cpf Ou Cnpj",
                        "Endereco Contratante", "Cidade Contratante", "Cep Contratante", "Estado Contratante"));
        assertEquals("Cep Contratante", actualCriaContratanteResult.getCepContratante());
        assertEquals("Razao Social Contratante", actualCriaContratanteResult.getRazaoSocialContratante());
        assertEquals("Nome", actualCriaContratanteResult.getNome());
        assertEquals("Estado Contratante", actualCriaContratanteResult.getEstadoContratante());
        assertEquals("Endereco Contratante", actualCriaContratanteResult.getEnderecoContratante());
        assertEquals("Cpf Ou Cnpj", actualCriaContratanteResult.getCpfCnpj());
        assertEquals("Cidade Contratante", actualCriaContratanteResult.getCidadeContratante());
        verify(contratanteRepository).salva((Contratante) any());
        assertSame(contratante, contratanteApplicationService.contratante);
    }


    @Test
    void testAlteraContratante() {
        Contratante request = new Contratante();
        request.setCepContratante("45830-300");
        request.setCidadeContratante("Cidade Contratante");
        request.setContratos(new ArrayList<>());
        request.setCpfCnpj("Cpf Ou Cnpj");
        request.setEnderecoContratante("Endereco Contratante");
        request.setEstadoContratante("Estado Contratante");
        request.setIdContratante(1L);
        request.setNome("Nome");
        request.setRazaoSocialContratante("Razao Social Contratante");
        request.setTipoPessoa(TipoPessoa.FISICA);

        Contratante response = new Contratante();
        response.setCepContratante("Cep Contratante");
        response.setCidadeContratante("Cidade Contratante");
        response.setContratos(new ArrayList<>());
        response.setCpfCnpj("Cpf Ou Cnpj");
        response.setEnderecoContratante("Endereco Contratante");
        response.setEstadoContratante("Estado Contratante");
        response.setIdContratante(1L);
        response.setNome("Nome");
        response.setRazaoSocialContratante("Razao Social Contratante");
        response.setTipoPessoa(TipoPessoa.FISICA);
        Optional<Contratante> ofResult = Optional.of(response);
        when(contratanteRepository.salva((Contratante) any())).thenReturn(request);
        when(contratanteRepository.findByCpfOrCnpj((String) any())).thenReturn(ofResult);
        Contratante actualAlteraContratanteResult = contratanteApplicationService
                .alteraContratante(new ContratanteRequest("Razao Social Contratante", "Nome", TipoPessoa.FISICA,
                        "Cpf Ou Cnpj", "Endereco Contratante", "Cidade Contratante", "Cep Contratante", "Estado Contratante"));
        assertSame(response, actualAlteraContratanteResult);
        verify(contratanteRepository).findByCpfOrCnpj((String) any());
        assertEquals(request.getCepContratante(), request.getCepContratante());
        assertSame(actualAlteraContratanteResult, contratanteApplicationService.contratante);
    }
}