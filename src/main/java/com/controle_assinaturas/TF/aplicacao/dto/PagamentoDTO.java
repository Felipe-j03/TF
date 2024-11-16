package com.controle_assinaturas.TF.aplicacao.dto;

import java.time.LocalDate;

import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;

public class PagamentoDTO {

    private Long codigo;
    private AssinaturaModel assinatura;
    private Double valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    public PagamentoDTO(Long codigo, AssinaturaModel assinatura, Double valorPago, LocalDate dataPagamento,
            String promocao) {
        this.codigo = codigo;
        this.valorPago = valorPago;
        this.assinatura = assinatura;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

}
