package com.controle_assinaturas.TF.dominio.entidades;

public class ClienteModel {

    private long codigo;
    private String nome;
    private String email;

    public ClienteModel(long codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}
