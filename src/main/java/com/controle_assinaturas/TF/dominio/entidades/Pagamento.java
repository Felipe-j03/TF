package com.controle_assinaturas.TF.dominio.entidades;

import java.time.LocalDate;

public class Pagamento {

    private long codigo;
    private double valorPago;
    private Assinatura assinatura;
    private LocalDate dataPagamento;
    private String promocao;

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

}
