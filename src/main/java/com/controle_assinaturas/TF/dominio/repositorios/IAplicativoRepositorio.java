package com.controle_assinaturas.TF.dominio.repositorios;

import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;

public interface IAplicativoRepositorio {

    public List<AplicativoModel> listarApps();
    public AplicativoModel consultaPorCod(long codigo);
    public void salvar(AplicativoModel aplicativo);

}
