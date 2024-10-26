package com.controle_assinaturas.TF.dominio.repositorios;

import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.Assinatura;

public interface IAssinaturaRepositorio {

    public List<Assinatura> listarAssinaturas();
    public List<Assinatura> listarAssinaturasValidas();
    public List<Assinatura> listarAssinaturasCliente();
    public List<Assinatura> listarAssinantesApp();
    public Assinatura consultaPorCod(long codigo);
    public void cadastrar(Assinatura assinatura);

}
