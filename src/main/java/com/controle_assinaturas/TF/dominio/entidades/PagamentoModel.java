package com.controle_assinaturas.TF.dominio.entidades;

import java.time.LocalDate;

public class PagamentoModel {

    private Long codigo;
    private AssinaturaModel assinatura;
    private Double valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    public PagamentoModel(Long codigo, AssinaturaModel assinatura, Double valorPago, LocalDate dataPagamento,
            String promocao) {
        this.codigo = codigo;
        this.valorPago = valorPago;
        this.assinatura = assinatura;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public AssinaturaModel getAssinatura() {
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

}
