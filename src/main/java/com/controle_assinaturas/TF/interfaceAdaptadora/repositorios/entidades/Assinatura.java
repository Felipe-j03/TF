package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades;

import java.time.LocalDate;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.entidades.ClienteModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Assinatura {

    @Id
    private Long codigo;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Cliente cliente;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Aplicativo aplicativo;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    protected Assinatura() {
    }

    public Assinatura(Long codigo, Aplicativo aplicativo, Cliente cliente, LocalDate inicioVigencia, LocalDate fimVigencia) {
        this.codigo = codigo;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
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

    public Aplicativo getAplicativo() {
        return aplicativo;
    }

    public Cliente getCliente() {
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

    public void setAplicativo(Aplicativo aplicativo) {
        this.aplicativo = aplicativo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static AssinaturaModel toAssinaturaModel(Assinatura assinatura) {

        AplicativoModel aplicativo = Aplicativo.toAplicativoModel(assinatura.getAplicativo());
        ClienteModel cliente = Cliente.toClienteModel(assinatura.getCliente());

        return new AssinaturaModel(assinatura.getCodigo(), aplicativo, cliente, assinatura.getInicioVigencia(), assinatura.getFimVigencia());
    }

    public static Assinatura toAssinatura(AssinaturaModel assinatura) {

        Aplicativo aplicativo = Aplicativo.toAplicativo(assinatura.getAplicativo());
        Cliente cliente = Cliente.toCliente(assinatura.getCliente());

        return new Assinatura(assinatura.getCodigo(), aplicativo, cliente, assinatura.getInicioVigencia(), assinatura.getFimVigencia());
    }

}
