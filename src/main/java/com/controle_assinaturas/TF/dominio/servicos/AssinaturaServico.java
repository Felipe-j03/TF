package com.controle_assinaturas.TF.dominio.servicos;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.entidades.ClienteModel;
import com.controle_assinaturas.TF.dominio.repositorios.IAplicativoRepositorio;
import com.controle_assinaturas.TF.dominio.repositorios.IAssinaturaRepositorio;
import com.controle_assinaturas.TF.dominio.repositorios.IClienteRepositorio;

public class AssinaturaServico {

    private final IAssinaturaRepositorio assinaturaRepositorio;
    private final IClienteRepositorio clienteRepositorio;
    private final IAplicativoRepositorio aplicativoRepositorio;

    public AssinaturaServico(IAplicativoRepositorio aplicativoRepositorio, IAssinaturaRepositorio assinaturaRepositorio, IClienteRepositorio clienteRepositorio) {
        this.aplicativoRepositorio = aplicativoRepositorio;
        this.assinaturaRepositorio = assinaturaRepositorio;
        this.clienteRepositorio = clienteRepositorio;
    }

    public List<AssinaturaModel> listarAssinaturas() {
        return assinaturaRepositorio.listarAssinaturas();
    }

    public AssinaturaModel consultarPorId(long id) {
        return assinaturaRepositorio.consultaPorCod(id);
    }

    public AssinaturaModel criarAssinatura(long clienteId, long aplicativoId) {
        
        int i = 0;
        int id = i++;

        ClienteModel cliente = clienteRepositorio.procuraPorCod(clienteId);
        AplicativoModel aplicativo = aplicativoRepositorio.consultaPorCod(aplicativoId);

        if (cliente == null && aplicativo == null) {
            throw new IllegalArgumentException("Cliente ou Aplicativo não encontrado");
        }

        AssinaturaModel assinatura = new AssinaturaModel(id, LocalDate.now(), LocalDate.now().plusDays(7), aplicativo, cliente);
        assinaturaRepositorio.salvar(assinatura);

        return assinatura;
    }

    public boolean isAssinaturaValida(AssinaturaModel assinatura) {
        return assinatura.getFimVigencia().isAfter(LocalDate.now());
    }

    public List<AssinaturaModel> listarAssinaturasPorCliente(long clienteId) {
        return assinaturaRepositorio.listarAssinaturaPorCliente(clienteId);
    }

    public List<AssinaturaModel> listarAssinantesPorAplicativo(long aplicativoId) {
        return assinaturaRepositorio.listarAssinantesPorAplicativo(aplicativoId);
    }

}
