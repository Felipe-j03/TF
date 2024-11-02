package com.controle_assinaturas.TF.dominio.repositorios;

import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.Aplicativo;
import com.controle_assinaturas.TF.dominio.entidades.Assinatura;
import com.controle_assinaturas.TF.dominio.entidades.Cliente;

public interface IAssinaturaRepositorio {

    public List<Assinatura> listarAssinaturas();
    public List<Assinatura> listarAssinaturasValidas();
    public List<Assinatura> listarAssinaturaPorCliente(Cliente cliente);
    public List<Assinatura> listarAssinantesPorAplicativo(Aplicativo aplicativo);
    public Assinatura consultaPorCod(long codigo);
    public void salvar(Assinatura assinatura);
    
}
