package com.controle_assinaturas.TF;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.repositorios.IPagamentoRepositorio;
import com.controle_assinaturas.TF.dominio.servicos.AplicativoServico;
import com.controle_assinaturas.TF.dominio.servicos.AssinaturaServico;
import com.controle_assinaturas.TF.dominio.servicos.PagamentoServico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

class PagamentoServicoTest {

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
    void testRegistrarPagamentoValorExatoSemPromocao() {
        // Arrange
        Long assinaturaId = 1L;
        Double valorPago = 100.0;
        int dia = 20, mes = 11, ano = 2024;

        AplicativoModel aplicativo = new AplicativoModel(1L, "App Teste", 100.0);
        AssinaturaModel assinatura = new AssinaturaModel(assinaturaId, aplicativo, null, LocalDate.now(),
                LocalDate.now().plusDays(30));

        when(assinaturaServico.consultaPorCodigo(assinaturaId)).thenReturn(assinatura);
        when(aplicativoServico.consultaPorCod(aplicativo.getCodigo())).thenReturn(aplicativo);

        // Act
        String resultado = pagamentoServico.registrarPagamento(assinaturaId, valorPago, dia, mes, ano);

        // Assert
        assertEquals("PAGAMENTO_OK - 2024-11-20 - 0.0", resultado);

    }

    @Test
    void testRegistrarPagamentoValorMaior() {
        // Arrange
        Long assinaturaId = 1L;
        Double valorPago = 150.0;
        int dia = 20, mes = 11, ano = 2024;

        AplicativoModel aplicativo = new AplicativoModel(1L, "App Teste", 100.0);
        AssinaturaModel assinatura = new AssinaturaModel(assinaturaId, aplicativo, null, LocalDate.now(),
                LocalDate.now().plusDays(30));

        when(assinaturaServico.consultaPorCodigo(assinaturaId)).thenReturn(assinatura);
        when(aplicativoServico.consultaPorCod(aplicativo.getCodigo())).thenReturn(aplicativo);

        // Act
        String resultado = pagamentoServico.registrarPagamento(assinaturaId, valorPago, dia, mes, ano);

        // Assert
        assertEquals("PAGAMENTO_OK - 2024-11-20 - 50.0", resultado);
    }

    @Test
    void testRegistrarPagamentoValorMenor() {
        // Arrange
        Long assinaturaId = 1L;
        Double valorPago = 50.0;
        int dia = 20, mes = 11, ano = 2024;

        AplicativoModel aplicativo = new AplicativoModel(1L, "App Teste", 100.0);
        AssinaturaModel assinatura = new AssinaturaModel(assinaturaId, aplicativo, null, LocalDate.now(),
                LocalDate.now().plusDays(30));

        when(assinaturaServico.consultaPorCodigo(assinaturaId)).thenReturn(assinatura);
        when(aplicativoServico.consultaPorCod(aplicativo.getCodigo())).thenReturn(aplicativo);

        // Act
        String resultado = pagamentoServico.registrarPagamento(assinaturaId, valorPago, dia, mes, ano);

        // Assert
        assertEquals("VALOR_INCORRETO - 2024-11-20 - 50.0", resultado);
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
