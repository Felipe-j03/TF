package com.controle_assinaturas.TF.dominio.repositorios;

import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.entidades.ClienteModel;

public interface IAssinaturaRepositorio {

    public List<AssinaturaModel> listarAssinaturas();
    public List<AssinaturaModel> listarAssinaturasValidas();
    public List<AssinaturaModel> listarAssinaturaPorCliente(ClienteModel cliente);
    public List<AssinaturaModel> listarAssinantesPorAplicativo(AplicativoModel aplicativo);
    public AssinaturaModel consultaPorCod(long codigo);
    public void salvar(AssinaturaModel assinatura);
    
}
