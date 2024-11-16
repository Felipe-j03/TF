package com.controle_assinaturas.TF.aplicacao.dto;

import java.time.LocalDate;

import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;

public class AssinaturaDTO {
    private long codigo;
    private Long aplicativoId;
    private Long clienteId;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
    private String status; 

    public AssinaturaDTO(long codigo, Long aplicativoId, Long clienteId, LocalDate inicioVigencia,
            LocalDate fimVigencia, String status) {
        this.codigo = codigo;
        this.aplicativoId = aplicativoId;
        this.clienteId = clienteId;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.status = status;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getAplicativo() {
        return aplicativoId;
    }

    public void setAplicativo(Long aplicativoId) {
        this.aplicativoId = aplicativoId;
    }

    public Long getCliente() {
        return clienteId;
    }

    public void setCliente(Long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(LocalDate inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(LocalDate fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static AssinaturaDTO fromModel(AssinaturaModel assinatura) {
        return new AssinaturaDTO(assinatura.getCodigo(),
                assinatura.getAplicativo().getCodigo(),
                assinatura.getCliente().getCodigo(),
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia(),
                assinatura.getFimVigencia().isAfter(LocalDate.now()) ? "ATIVA" : "CANCELADA"); // Atribuindo status
                                                                                               // corretamente aqui
    }

    @Override
    public String toString() {
        return "AssinaturaDTO [codigo=" + codigo + ", aplicativoId=" + aplicativoId + ", clienteId=" + clienteId
                + ", inicioVigencia=" + inicioVigencia + ", fimVigencia=" + fimVigencia + ", status=" + status + "]";
    }
}
