package com.controle_assinaturas.TF.dominio.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.controle_assinaturas.TF.dominio.entidades.ClienteModel;
import com.controle_assinaturas.TF.dominio.repositorios.IClienteRepositorio;

@Service
public class ClienteServico {

    private final IClienteRepositorio clienteRepositorio;

    public ClienteServico(IClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public List<ClienteModel> listarClientes() {
        return clienteRepositorio.listarClientes();
    }

    public ClienteModel procuraPorCod(Long codigo) {
        List<ClienteModel> clientes = clienteRepositorio.listarClientes();
        return clientes.stream().filter(s -> s.getCodigo() == codigo).findFirst().orElse(null);
    }

}
