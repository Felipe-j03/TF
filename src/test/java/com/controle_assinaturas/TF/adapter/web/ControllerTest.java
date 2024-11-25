package com.controle_assinaturas.TF.adapter.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.repositorios.IPagamentoRepositorio;
import com.controle_assinaturas.TF.dominio.servicos.AplicativoServico;
import com.controle_assinaturas.TF.dominio.servicos.AssinaturaServico;
import com.controle_assinaturas.TF.dominio.servicos.PagamentoServico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    @Mock
    private AssinaturaServico assinaturaServico;

    @Mock
    private AplicativoServico aplicativoServico;

    @Mock
    private IPagamentoRepositorio pagamentoRepositorio;

    private PagamentoServico pagamentoServico;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pagamentoServico = new PagamentoServico(aplicativoServico, assinaturaServico, pagamentoRepositorio);
    }

    @Test
    void testAplicarPromocao45Dias() {
        // Arrange
        Long assinaturaId = 1L;
        String promocao = "PAGUE_30_GANHE_45";

        AplicativoModel aplicativo = new AplicativoModel(1L, "App Teste", 100.0);
        AssinaturaModel assinatura = new AssinaturaModel(assinaturaId, aplicativo, null, LocalDate.now(),
                LocalDate.now().plusDays(30));

        when(assinaturaServico.consultaPorCodigo(assinaturaId)).thenReturn(assinatura);

        // Act
        pagamentoServico.aplicarPromocao(assinaturaId, promocao);

        // Assert
        assertEquals(LocalDate.now().plusDays(45), assinatura.getFimVigencia());
    }

    @Test
    void testAplicarPromocao5PorCentoDesconto() {
        // Arrange
        Long assinaturaId = 1L;
        String promocao = "5_MENSAL";

        AplicativoModel aplicativo = new AplicativoModel(1L, "App Teste", 100.0);
        AssinaturaModel assinatura = new AssinaturaModel(assinaturaId, aplicativo, null, LocalDate.now(),
                LocalDate.now().plusDays(30));

        when(assinaturaServico.consultaPorCodigo(assinaturaId)).thenReturn(assinatura);

        // Act
        pagamentoServico.aplicarPromocao(assinaturaId, promocao);

        // Assert
        assertEquals(95.0, assinatura.getAplicativo().getCustoMensal());
    }

}
