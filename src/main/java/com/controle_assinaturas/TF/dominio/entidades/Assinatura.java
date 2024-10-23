package com.controle_assinaturas.TF.dominio.entidades;

import java.util.Date;

public class Assinatura {

    private long codigo;
    private Date inicioVigencia;
    private Date fimVigencia;
    private Aplicativo aplicativo;
    private Cliente cliente;

    public Assinatura(long codigo, Date inicioVigencia, Date fimVigencia, Aplicativo aplicativo, Cliente cliente) {
        this.codigo = codigo;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
    }

    public long getCodigo() {
        return codigo;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public Aplicativo getAplicativo() {
        return aplicativo;
    }

    public Cliente getCliente() {
        return cliente;
    }

}
