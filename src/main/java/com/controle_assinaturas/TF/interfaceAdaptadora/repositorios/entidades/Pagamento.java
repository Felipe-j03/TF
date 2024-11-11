package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades;

import java.time.LocalDate;

import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.entidades.PagamentoModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pagamento {

    @Id
    private Long codigo;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Assinatura assinatura;
    private Double valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    protected Pagamento() {
    }

    public Pagamento(Long codigo, Assinatura assinatura, Double valorPago, LocalDate dataPagamento, String promocao) {
        this.codigo = codigo;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }

    public Double getValorPago() {
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

        return new PagamentoModel(pagamento.getCodigo(), assinatura, pagamento.getValorPago(), pagamento.getDataPagamento(), pagamento.getPromocao());
    }

    public static Pagamento toPagamento(PagamentoModel pagamento) {

        Assinatura assinatura = Assinatura.toAssinatura(pagamento.getAssinatura());

        return new Pagamento(pagamento.getCodigo(), assinatura, pagamento.getValorPago(), pagamento.getDataPagamento(), pagamento.getPromocao());
    }
}
