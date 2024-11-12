package com.controle_assinaturas.TF.dominio.servicos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.entidades.ClienteModel;
import com.controle_assinaturas.TF.dominio.repositorios.IAssinaturaRepositorio;

@Service
public class AssinaturaServico {
    private final IAssinaturaRepositorio assinaturaRepositorio;
    private final ClienteServico clienteServico;
    private final AplicativoServico aplicativoServico;

    public AssinaturaServico(AplicativoServico aplicativoServico, IAssinaturaRepositorio assinaturaRepositorio,
            ClienteServico clienteServico) {
        this.aplicativoServico = aplicativoServico;
        this.assinaturaRepositorio = assinaturaRepositorio;
        this.clienteServico = clienteServico;
    }

    public List<AssinaturaModel> listarAssinaturas() {
        List<AssinaturaModel> assinaturas = assinaturaRepositorio.listarAssinaturas();
        return assinaturas.stream().toList();
    }

    public AssinaturaModel consultaPorCodigo(Long codigo) {
        List<AssinaturaModel> assinaturas = assinaturaRepositorio.listarAssinaturas();
        return assinaturas.stream().filter(ass -> ass.getCodigo() == codigo).findFirst().orElse(null);
    }

    public AssinaturaModel criarAssinatura(Long codigoCliente, Long codigoAplicativo) {

        int i = 1;
        long id = i;

        ClienteModel cliente = clienteServico.procuraPorCod(codigoCliente);
        AplicativoModel aplicativo = aplicativoServico.consultaPorCod(codigoAplicativo);

        if (cliente == null && aplicativo == null) {
            throw new IllegalArgumentException("Cliente ou Aplicativo não encontrado");
        }

        AssinaturaModel assinatura = new AssinaturaModel(id, aplicativo, cliente, LocalDate.now(),
                LocalDate.now().plusDays(7));
        assinaturaRepositorio.salvar(assinatura);
        i++;

        return assinatura;
    }

    public boolean isAssinaturaValida(AssinaturaModel assinatura) {
        return assinatura.getFimVigencia().isAfter(LocalDate.now());
    }

    public List<AssinaturaModel> listarAssinaturasPorCliente(Long codigoCliente) {
        return assinaturaRepositorio.listarAssinaturaPorCliente(codigoCliente);
    }

    public List<AssinaturaModel> listarAssinantesPorAplicativo(Long codigoAplicativo) {
        return assinaturaRepositorio.listarAssinantesPorAplicativo(codigoAplicativo);
    }
    
    public void salvar(AssinaturaModel assinatura){
        assinaturaRepositorio.salvar(assinatura);
    }
    
    

}
