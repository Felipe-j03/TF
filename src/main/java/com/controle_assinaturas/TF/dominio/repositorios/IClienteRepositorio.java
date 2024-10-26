package com.controle_assinaturas.TF.dominio.repositorios;

import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.Assinatura;
import com.controle_assinaturas.TF.dominio.entidades.Cliente;

public interface IClienteRepositorio {

    public List<Cliente> listarClientes();
    public Cliente procuraPorCod(long codigo);
    public void cadastrarAssinatura(Assinatura assinatura);

}
