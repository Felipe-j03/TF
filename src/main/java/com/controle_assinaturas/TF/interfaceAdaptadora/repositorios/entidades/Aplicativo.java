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
    private Long codigo;
    private String nome;
    private Double custoMensal;

    protected Aplicativo() {
    }

    public Aplicativo(Long codigo, String nome, Double custoMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Double getCustoMensal() {
        return custoMensal;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCustoMensal(Double custoMensal) {
        this.custoMensal = custoMensal;
    }

    @Override
    public String toString() {
        return "Aplicativo [codigo=" + codigo + ", nome=" + nome + ", custoMensal=" + custoMensal + "]";
    }

    public static AplicativoModel toAplicativoModel(Aplicativo aplicativo) {
        return new AplicativoModel(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal());
    }

    public static Aplicativo toAplicativo(AplicativoModel aplicativo) {
        return new Aplicativo(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal());
    }

}
