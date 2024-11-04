package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades;

import java.time.LocalDate;

import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.entidades.PagamentoModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @ManyToOne
    @JoinColumn(name = "assinatura_id")
    private Assinatura assinatura;

    private LocalDate dataPagamento;
    private double valorPago;
    private String promocao;

    protected Pagamento() {
    }

    public Pagamento(long codigo, double valorPago, Assinatura assinatura, LocalDate dataPagamento, String promocao) {
        this.codigo = codigo;
        this.valorPago = valorPago;
        this.assinatura = assinatura;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public long getCodigo() {
        return codigo;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }

    public double getValorPago() {
        return valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }

    public static PagamentoModel toPagamentoModel(Pagamento pagamento) {

        AssinaturaModel assinatura = Assinatura.toAssinaturaModel(pagamento.getAssinatura());

        return new PagamentoModel(pagamento.getCodigo(), pagamento.getValorPago(), assinatura, pagamento.getDataPagamento(), pagamento.getPromocao());
    }

    public static Pagamento toPagamento(PagamentoModel pagamento) {

        Assinatura assinatura = Assinatura.toAssinatura(pagamento.getAssinatura());

        return new Pagamento(pagamento.getCodigo(), pagamento.getValorPago(), assinatura, pagamento.getDataPagamento(), pagamento.getPromocao());
    }
}
