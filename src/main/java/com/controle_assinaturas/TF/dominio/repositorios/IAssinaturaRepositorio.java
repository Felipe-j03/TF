package com.controle_assinaturas.TF.dominio.repositorios;

import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;

public interface IAssinaturaRepositorio {

    public List<AssinaturaModel> listarAssinaturas();
    public List<AssinaturaModel> listarAssinaturasValidas();
    public List<AssinaturaModel> listarAssinaturaPorCliente(long clienteId);
    public List<AssinaturaModel> listarAssinantesPorAplicativo(long aplicativoId);
    public AssinaturaModel consultaPorCod(long codigo);
    public void salvar(AssinaturaModel assinatura);
    
}
