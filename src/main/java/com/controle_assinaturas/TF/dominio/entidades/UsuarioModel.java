package com.controle_assinaturas.TF.dominio.entidades;

public class UsuarioModel {

    private String usuario;
    private String senha;

    public UsuarioModel(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

}
