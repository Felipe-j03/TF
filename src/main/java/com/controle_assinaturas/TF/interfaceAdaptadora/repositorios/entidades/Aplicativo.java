package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aplicativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    private String nome;
    private Double custoMensal;

    protected Aplicativo() {
    }

    public Aplicativo(long codigo, String nome, double custoMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getCustoMensal() {
        return custoMensal;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCustoMensal(double custoMensal) {
        this.custoMensal = custoMensal;
    }
    
    public static AplicativoModel toAplicativoModel(Aplicativo aplicativo) {
        return new AplicativoModel(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal());
    }

    public static Aplicativo toAplicativo(AplicativoModel aplicativo) {
        return new Aplicativo(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal());
    }

}
