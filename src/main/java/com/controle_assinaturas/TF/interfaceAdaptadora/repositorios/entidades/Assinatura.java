package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades;

import java.time.LocalDate;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "aplicativo_id")
    private Aplicativo aplicativo;

    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    protected Assinatura() {
    }

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

    public static AssinaturaModel toAssinaturaModel(Assinatura assinatura) {
        return new AssinaturaModel(assinatura.getCodigo(), assinatura.getInicioVigencia(), assinatura.getFimVigencia(), Aplicativo.toAplicativoModel(assinatura.getAplicativo()), assinatura.getCliente());
    }

    public static Aplicativo toAplicativo(AplicativoModel assinatura) {
        return new Aplicativo(assinatura.getCodigo(), assinatura.getNome(), assinatura.getCustoMensal());
    }

}
