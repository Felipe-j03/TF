package com.controle_assinaturas.TF.dominio.servicos;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.entidades.PagamentoModel;
import com.controle_assinaturas.TF.dominio.repositorios.IPagamentoRepositorio;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Pagamento;

@Service
public class PagamentoServico {
    private final IPagamentoRepositorio pagamentoRepositorio;
    private final AssinaturaServico assinaturaServico;
    private final AplicativoServico aplicativoServico;
    private final List<PagamentoModel> historicoDePagamentos;

    public PagamentoServico(AplicativoServico aplicativoServico, AssinaturaServico assinaturaServico,
            IPagamentoRepositorio pagamentoRepositorio) {
        this.aplicativoServico = aplicativoServico;
        this.assinaturaServico = assinaturaServico;
        this.pagamentoRepositorio = pagamentoRepositorio;
        this.historicoDePagamentos = new LinkedList<>();
    }

    public String registrarPagamento(Long codass, Double valorPago, int dia, int mes, int ano) {
        // Buscar assinatura pelo código
        AssinaturaModel assinatura = assinaturaServico.consultaPorCodigo(codass);
        LocalDate data = LocalDate.of(ano, mes, dia); // Criando a data a partir dos parâmetros

        // Verificar se a assinatura existe
        if (assinatura == null) {
            throw new IllegalArgumentException("Assinatura não encontrada.");
        }

        // Buscar aplicativo associado à assinatura
        AplicativoModel aplicativo = aplicativoServico.consultaPorCod(assinatura.getAplicativo().getCodigo());

        // Verificar se o aplicativo existe
        if (aplicativo == null) {
            throw new IllegalArgumentException("Aplicativo associado à assinatura não encontrado");
        }

        // Criar o pagamento
        PagamentoModel pagamento = new PagamentoModel(codass, assinatura, valorPago, data, null);
        historicoDePagamentos.add(pagamento);

        // Verificar se o valor pago está correto ou maior que o esperado
        Double custoBase = assinatura.getAplicativo().getCustoMensal();
        Double valorEstornado = 0.0;

        // Verificar se o valor pago está correto
        if (valorPago < custoBase) {
            valorEstornado = valorPago; // Estorno total se o valor estiver incorreto
            return "VALOR_INCORRETO - " + data + " - " + valorEstornado;
        }
        if (valorPago > custoBase) {
            valorEstornado = valorPago - custoBase;
            return "PAGAMENTO_OK - " + data + " - " + valorEstornado;
        }

        // Caso o valor pago seja exato, não há estorno, apenas confirmação
        return "PAGAMENTO_OK - " + data + " - " + valorEstornado;
    }

    /**
     * Obtém o histórico de pagamentos de uma assinatura.
     *
     * @param assinaturaId ID da assinatura para obter o histórico.
     * @return Lista de pagamentos feitos para a assinatura.
     */
    public List<PagamentoModel> obterHistoricoPagamentos(Long assinaturaId) {
        return pagamentoRepositorio.historicoPagamentoPorID(assinaturaId);
    }
}
