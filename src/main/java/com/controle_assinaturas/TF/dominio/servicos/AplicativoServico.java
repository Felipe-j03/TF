package com.controle_assinaturas.TF.dominio.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.repositorios.IAplicativoRepositorio;

@Service
public class AplicativoServico {
    private final IAplicativoRepositorio aplicativoRepositorio;

    public AplicativoServico(IAplicativoRepositorio aplicativoRepositorio) {
        this.aplicativoRepositorio = aplicativoRepositorio;
    }

    public List<AplicativoModel> listarAplicativos() {
        List<AplicativoModel> aplicativos = aplicativoRepositorio.listarApps();
        return aplicativos.stream().toList();
    }

    public AplicativoModel consultaPorCod(Long codigo) {
        List<AplicativoModel> aplicativos = aplicativoRepositorio.listarApps();
        return aplicativos.stream().filter(app -> app.getCodigo() == codigo).findFirst().orElse(null);

    }

    public AplicativoModel atualizarPrecoApp(Long aplicativoId, Double novoPreco) {

        AplicativoModel aplicativo = consultaPorCod(aplicativoId);

        if (aplicativo == null) {
            throw new IllegalArgumentException("Aplicativo inválido");
        }

        aplicativo.setCustoMensal(novoPreco);
        aplicativoRepositorio.salvar(aplicativo);
        return aplicativo;

    }
}
