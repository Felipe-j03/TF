package com.controle_assinaturas.TF.dominio.entidades;

import java.time.LocalDate;

public class AssinaturaModel {

    private long codigo;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
    private AplicativoModel aplicativo;
    private ClienteModel cliente;

    public AssinaturaModel(long codigo, LocalDate inicioVigencia, LocalDate fimVigencia, AplicativoModel aplicativo, ClienteModel cliente) {
        this.codigo = codigo;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
    }

    public long getCodigo() {
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

    public void setCodigo(long codigo) {
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
