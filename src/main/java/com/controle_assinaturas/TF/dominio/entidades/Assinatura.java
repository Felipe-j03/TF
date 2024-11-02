package com.controle_assinaturas.TF.dominio.entidades;

import java.time.LocalDate;

public class Assinatura {

    private long codigo;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
    private Aplicativo aplicativo;
    private Cliente cliente;

    public Assinatura(long codigo, LocalDate inicioVigencia, LocalDate fimVigencia, Aplicativo aplicativo, Cliente cliente) {
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

    public Aplicativo getAplicativo() {
        return aplicativo;
    }

    public Cliente getCliente() {
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

    public void setAplicativo(Aplicativo aplicativo) {
        this.aplicativo = aplicativo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    

}
