package com.controle_assinaturas.TF.dominio.repositorios;

import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.Aplicativo;
import com.controle_assinaturas.TF.dominio.entidades.Assinatura;

public interface IAplicativoRepositorio {

    public List<Aplicativo> listarApps();
    public List<Assinatura> listarAssinantes();
    public Aplicativo consultaPorCod(long codigo);
    public void salvar(Aplicativo aplicativo);

}
