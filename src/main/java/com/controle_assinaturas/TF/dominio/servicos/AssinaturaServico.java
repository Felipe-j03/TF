package com.controle_assinaturas.TF.dominio.servicos;

import java.time.LocalDate;
import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.entidades.ClienteModel;
import com.controle_assinaturas.TF.dominio.repositorios.IAssinaturaRepositorio;

public class AssinaturaServico {

    private final IAssinaturaRepositorio assinaturaRepositorio;

    public AssinaturaServico(IAssinaturaRepositorio assinaturaRepositorio) {
        this.assinaturaRepositorio = assinaturaRepositorio;
    }

    public List<AssinaturaModel> listarAssinaturas() {
        return assinaturaRepositorio.listarAssinaturas();
    }

    public List<AssinaturaModel> assinaturasValidas() {
        return assinaturaRepositorio.listarAssinaturasValidas();
    }

    public AssinaturaModel consultarPorId(long id) {
        return assinaturaRepositorio.consultaPorCod(id);
    }

    public void cadastrarAssinatura(long id, ClienteModel cliente, AplicativoModel aplicativo) {
        AssinaturaModel assinatura = new AssinaturaModel(id, LocalDate.now(), LocalDate.now().plusDays(7), aplicativo, cliente);
        assinaturaRepositorio.salvar(assinatura);
    }

    public boolean isAssinaturaValida(AssinaturaModel assinatura) {
        return assinatura.getFimVigencia().isAfter(LocalDate.now());
    }

    public List<AssinaturaModel> listarAssinaturasPorCliente(ClienteModel cliente) {
        return assinaturaRepositorio.listarAssinaturaPorCliente(cliente);
    }

    public List<AssinaturaModel> listarAssinantesPorAplicativo(AplicativoModel aplicativo) {
        return assinaturaRepositorio.listarAssinantesPorAplicativo(aplicativo);
    }

}
