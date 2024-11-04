package com.controle_assinaturas.TF.dominio.repositorios;

import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.entidades.ClienteModel;

public interface IClienteRepositorio {

    public List<ClienteModel> listarClientes();
    public ClienteModel procuraPorCod(long codigo);
}
