package com.controle_assinaturas.TF.dominio.servicos;

import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.ClienteModel;
import com.controle_assinaturas.TF.dominio.repositorios.IClienteRepositorio;

public class ClienteServico {

    private final IClienteRepositorio clienteRepositorio;

    public ClienteServico(IClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public List<ClienteModel> listarClientes() {
        return clienteRepositorio.listarClientes();
    }

    public ClienteModel procuraPorCod(long codigo) {
        return clienteRepositorio.procuraPorCod(codigo);
    }

}
