package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades;

import com.controle_assinaturas.TF.dominio.entidades.ClienteModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    private Long codigo;
    private String nome;
    private String email;

    protected Cliente() {
    }

    public Cliente(Long codigo, String nome, String email) {
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
    
    public static ClienteModel toClienteModel(Cliente cliente){
        return new ClienteModel(cliente.getCodigo(), cliente.getNome(), cliente.getEmail());
    }
    public static Cliente toCliente(ClienteModel cliente){
        return new Cliente(cliente.getCodigo(), cliente.getNome(), cliente.getEmail());
    }
    
}
