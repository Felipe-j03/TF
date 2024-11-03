package com.controle_assinaturas.TF.dominio.servicos;

import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.repositorios.IAplicativoRepositorio;

public class AplicativoServico {
    private final IAplicativoRepositorio aplicativoRepositorio;

    public AplicativoServico(IAplicativoRepositorio aplicativoRepositorio) {
        this.aplicativoRepositorio = aplicativoRepositorio;
    }

    public void adicionarAplicativo(AplicativoModel aplicativo) {
        aplicativoRepositorio.salvar(aplicativo);
    }

    public List<AplicativoModel> listarAplicativos() {
        return aplicativoRepositorio.listarApps();
    }

    public void atualizarCustoApp(double novoCusto, AplicativoModel aplicativo){
        if(aplicativo == null){
            throw new IllegalArgumentException("Aplicativo não existe");
        }
        aplicativo.setCustoMensal(novoCusto);
    }
}
