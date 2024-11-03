package com.controle_assinaturas.TF.dominio.servicos;

import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.repositorios.IAplicativoRepositorio;

public class AplicativoServico {

    private final IAplicativoRepositorio aplicativoRepositorio;

    public AplicativoServico(IAplicativoRepositorio aplicativoRepositorio) {
        this.aplicativoRepositorio = aplicativoRepositorio;
    }

    public AplicativoModel atualizarPrecoApp(long aplicativoId, double novoPreco) {

        AplicativoModel aplicativo = aplicativoRepositorio.consultaPorCod(aplicativoId);

        if (aplicativo == null) {
            throw new IllegalArgumentException("Aplicativo inválido");
        }

        aplicativo.setCustoMensal(novoPreco);
        aplicativoRepositorio.salvar(aplicativo);
        return aplicativo;

    }

    public List<AplicativoModel> listarAplicativos() {
        return aplicativoRepositorio.listarApps();
    }
}
