package com.controle_assinaturas.TF.dominio.entidades;

import java.time.LocalDate;

public class AssinaturaModel {

    private Long codigo;
    private AplicativoModel aplicativo;
    private ClienteModel cliente;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    public AssinaturaModel(Long codigo, AplicativoModel aplicativo, ClienteModel cliente, LocalDate inicioVigencia, LocalDate fimVigencia) {
        this.codigo = codigo;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public Long getCodigo() {
        return codigo;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public AplicativoModel getAplicativo() {
        return aplicativo;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setInicioVigencia(LocalDate inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public void setFimVigencia(LocalDate fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public void setAplicativo(AplicativoModel aplicativo) {
        this.aplicativo = aplicativo;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
    
    

}
