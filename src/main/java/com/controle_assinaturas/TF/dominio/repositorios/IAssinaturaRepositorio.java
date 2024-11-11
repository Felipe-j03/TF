package com.controle_assinaturas.TF.dominio.repositorios;

import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;

public interface IAssinaturaRepositorio {

    public List<AssinaturaModel> listarAssinaturas();
    public List<AssinaturaModel> listarAssinaturaPorCliente(Long clienteId);
    public List<AssinaturaModel> listarAssinantesPorAplicativo(Long aplicativoId);
    public AssinaturaModel consultaPorCod(Long codigo);
    public void salvar(AssinaturaModel assinatura);
    
}
