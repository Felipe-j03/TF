package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.JPAImp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.controle_assinaturas.TF.dominio.entidades.ClienteModel;
import com.controle_assinaturas.TF.dominio.repositorios.IClienteRepositorio;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Cliente;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA.ClienteJPA;

@Repository
public class ClienteJPAImp implements IClienteRepositorio {

    private final ClienteJPA clienteJPA;

    public ClienteJPAImp(ClienteJPA clienteJPA) {
        this.clienteJPA = clienteJPA;
    }

    @Override
    public List<ClienteModel> listarClientes() {

        List<Cliente> clientes = clienteJPA.findAll();

        return clientes.stream().map(assn -> Cliente.toClienteModel(assn)).toList();
    }

    @Override
    public ClienteModel procuraPorCod(long codigo) {

        List<Cliente> clientes = clienteJPA.findAll();

        Cliente cliente = clientes.stream()
                .filter(c -> c.getCodigo() == codigo)
                .findFirst()
                .orElse(null);

        if (cliente == null) {
            throw new IllegalArgumentException("Assinatura não encontrada");
        }

        return Cliente.toClienteModel(cliente);
    }
}
