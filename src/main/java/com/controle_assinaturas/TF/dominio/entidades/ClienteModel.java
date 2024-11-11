package com.controle_assinaturas.TF.dominio.entidades;

public class ClienteModel {

    private Long codigo;
    private String nome;
    private String email;

    public ClienteModel(Long codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}
