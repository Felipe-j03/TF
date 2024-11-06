package com.controle_assinaturas.TF.dominio.servicos;

import java.time.LocalDate;
import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.entidades.PagamentoModel;
import com.controle_assinaturas.TF.dominio.repositorios.IAplicativoRepositorio;
import com.controle_assinaturas.TF.dominio.repositorios.IAssinaturaRepositorio;
import com.controle_assinaturas.TF.dominio.repositorios.IPagamentoRepositorio;

public class PagamentoServico {

    private final IAssinaturaRepositorio assinaturaRepositorio;
    private final IPagamentoRepositorio pagamentoRepositorio;
    private final IAplicativoRepositorio aplicativoRepositorio;

    public PagamentoServico(IAplicativoRepositorio aplicativoRepositorio, IAssinaturaRepositorio assinaturaRepositorio, IPagamentoRepositorio pagamentoRepositorio) {
        this.aplicativoRepositorio = aplicativoRepositorio;
        this.assinaturaRepositorio = assinaturaRepositorio;
        this.pagamentoRepositorio = pagamentoRepositorio;
    }

    public LocalDate registrarPagamento(long assinaturaId, double valorPago, String promocao) {
        AssinaturaModel assinatura = assinaturaRepositorio.consultaPorCod(assinaturaId);
        if (assinatura == null) {
            throw new IllegalArgumentException("Assinatura não encontrada.");
        }

        AplicativoModel aplicativo = aplicativoRepositorio.consultaPorCod(assinatura.getAplicativo().getCodigo());

        if (aplicativo == null) {
            throw new IllegalArgumentException("Aplicativo associado à assinatura não encontrado");
        }

        // Verificar se o valor pago está correto
        if (!isValorPagamentoCorreto(assinatura, valorPago, promocao)) {
            double valorEstorno = valorPago;
            throw new IllegalArgumentException("Valor de pagamento incorreto. Valor estornado: " + valorEstorno);
        }

        // Aplicar promoção e calcular nova data de validade
        LocalDate novaDataValidade = calcularNovaValidade(assinatura, promocao);

        // Atualizar validade da assinatura e salvar pagamento
        assinatura.setFimVigencia(novaDataValidade);
        assinaturaRepositorio.salvar(assinatura);

        salvarPagamento(assinatura, valorPago, promocao);

        return novaDataValidade;
    }

    /**
     * Verifica se o valor pago é correto com base no custo do aplicativo e na
     * promoção aplicada.
     */
    private boolean isValorPagamentoCorreto(AssinaturaModel assinatura, double valorPago, String promocao) {
        double custoBase = assinatura.getAplicativo().getCustoMensal();
        if ("ANUAL_40_OFF".equals(promocao)) {          
            return valorPago == (custoBase * 12 * 0.4);
        } else {
            return valorPago == custoBase;
        }
    }

    /**
     * Calcula a nova data de validade da assinatura com base na promoção.
     */
    private LocalDate calcularNovaValidade(AssinaturaModel assinatura, String promocao) {
        LocalDate validadeAtual = assinatura.getFimVigencia();
        LocalDate dataAtual = LocalDate.now();

        // Caso a assinatura esteja "cancelada" (data de validade anterior à data atual)
        if (validadeAtual.isBefore(dataAtual)) {
            validadeAtual = dataAtual;
        }

        if (promocao.equals("PAGUE_30_GANHE_45")) {
            return validadeAtual.plusDays(45);
        } else if (promocao.equals("ANUAL_40_OFF")) {
            return validadeAtual.plusDays(365);
        } else {
            return validadeAtual.plusDays(30); // Extensão padrão de 30 dias para o plano básico
        }
    }

    /**
     * Salva o pagamento no banco de dados para manter o histórico.
     */
    private void salvarPagamento(AssinaturaModel assinatura, double valorPago, String promocao) {
        PagamentoModel pagamento = new PagamentoModel(assinatura.getCodigo(), valorPago, assinatura, LocalDate.now(), promocao);

        pagamentoRepositorio.salvar(pagamento);
    }

    /**
     * Obtém o histórico de pagamentos de uma assinatura.
     *
     * @param assinaturaId ID da assinatura para obter o histórico.
     * @return Lista de pagamentos feitos para a assinatura.
     */
    public List<PagamentoModel> obterHistoricoPagamentos(long assinaturaId) {
        return pagamentoRepositorio.historicoPagamentoPorID(assinaturaId);
    }
}
