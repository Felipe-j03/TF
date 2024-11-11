package com.controle_assinaturas.TF.dominio.servicos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.entidades.ClienteModel;
import com.controle_assinaturas.TF.dominio.repositorios.IAplicativoRepositorio;
import com.controle_assinaturas.TF.dominio.repositorios.IAssinaturaRepositorio;
import com.controle_assinaturas.TF.dominio.repositorios.IClienteRepositorio;

@Service
public class AssinaturaServico {
    private final IAssinaturaRepositorio assinaturaRepositorio;
    private final IClienteRepositorio clienteRepositorio;
    private final IAplicativoRepositorio aplicativoRepositorio;

    public AssinaturaServico(IAplicativoRepositorio aplicativoRepositorio, IAssinaturaRepositorio assinaturaRepositorio,
            IClienteRepositorio clienteRepositorio) {
        this.aplicativoRepositorio = aplicativoRepositorio;
        this.assinaturaRepositorio = assinaturaRepositorio;
        this.clienteRepositorio = clienteRepositorio;
    }

    public List<AssinaturaModel> listarAssinaturas() {
        return assinaturaRepositorio.listarAssinaturas();
    }

    public AssinaturaModel consultarPorId(Long id) {
        return assinaturaRepositorio.consultaPorCod(id);
    }

    public AssinaturaModel criarAssinatura(Long clienteId, Long aplicativoId) {

        long id = 1;

        ClienteModel cliente = clienteRepositorio.procuraPorCod(clienteId);
        AplicativoModel aplicativo = aplicativoRepositorio.consultaPorCod(aplicativoId);

        if (cliente == null && aplicativo == null) {
            throw new IllegalArgumentException("Cliente ou Aplicativo não encontrado");
        }

        AssinaturaModel assinatura = new AssinaturaModel(id, aplicativo, cliente, LocalDate.now(),
                LocalDate.now().plusDays(7));
        assinaturaRepositorio.salvar(assinatura);
        id++;

        return assinatura;
    }

    public boolean isAssinaturaValida(AssinaturaModel assinatura) {
        return assinatura.getFimVigencia().isAfter(LocalDate.now());
    }

    public List<AssinaturaModel> listarAssinaturasPorCliente(Long clienteId) {
        return assinaturaRepositorio.listarAssinaturaPorCliente(clienteId);
    }

    public List<AssinaturaModel> listarAssinantesPorAplicativo(Long aplicativoId) {
        return assinaturaRepositorio.listarAssinantesPorAplicativo(aplicativoId);
    }

}
