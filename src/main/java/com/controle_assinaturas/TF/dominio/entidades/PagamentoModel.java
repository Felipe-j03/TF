package com.controle_assinaturas.TF.dominio.entidades;

import java.time.LocalDate;

public class PagamentoModel {

    private long codigo;
    private double valorPago;
    private AssinaturaModel assinatura;
    private LocalDate dataPagamento;
    private String promocao;

    public PagamentoModel(long codigo, double valorPago, AssinaturaModel assinatura, LocalDate dataPagamento, String promocao) {
        this.codigo = codigo;
        this.valorPago = valorPago;
        this.assinatura = assinatura;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public long getCodigo() {
        return codigo;
    }

    public AssinaturaModel getAssinatura() {
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

}
