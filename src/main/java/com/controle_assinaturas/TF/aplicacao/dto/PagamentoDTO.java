package com.controle_assinaturas.TF.aplicacao.dto;

import java.time.LocalDate;

public class PagamentoDTO {

    private Long codigo;
    private Long assinaturaId;
    private Double valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    public PagamentoDTO(Long codigo, Long assinaturaId, Double valorPago, LocalDate dataPagamento,
            String promocao) {
        this.codigo = codigo;
        this.valorPago = valorPago;
        this.assinaturaId = assinaturaId;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getAssinaturaId() {
        return assinaturaId;
    }

    public void setAssinaturaId(Long assinaturaId) {
        this.assinaturaId = assinaturaId;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }
    
    

}
