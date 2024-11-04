package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.JPAImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.repositorios.IAssinaturaRepositorio;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Assinatura;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA.AssinaturaJPA;

@Repository
public class AssinaturaJPAImp implements IAssinaturaRepositorio {

    private final AssinaturaJPA assinaturaJPA;

    public AssinaturaJPAImp(AssinaturaJPA assinaturaJPA) {
        this.assinaturaJPA = assinaturaJPA;
    }

    @Override
    public List<AssinaturaModel> listarAssinaturas() {

        List<Assinatura> assinaturas = assinaturaJPA.findAll();

        return assinaturas.stream()
                .map(ass -> Assinatura.toAssinaturaModel(ass))
                .toList();
    }

    @Override
    public List<AssinaturaModel> listarAssinaturaPorCliente(long clienteId) {

        List<Assinatura> assinaturas = assinaturaJPA.findAll();

        // Filtra assinaturas pelo clienteId e mapeia para AssinaturaModel
        List<AssinaturaModel> assns = assinaturas.stream()
                .filter(assn -> assn.getCliente().getCodigo() == clienteId)
                .map(assn -> Assinatura.toAssinaturaModel(assn))
                .collect(Collectors.toList());

        return assns;
    }

    @Override
    public List<AssinaturaModel> listarAssinantesPorAplicativo(long aplicativoId) {

        List<Assinatura> assinaturas = assinaturaJPA.findAll();

        List<AssinaturaModel> assns = assinaturas.stream()
                .filter(assn -> assn.getAplicativo().getCodigo() == aplicativoId)
                .map(Assinatura::toAssinaturaModel)
                .collect(Collectors.toList());

        return assns;
    }

    @Override
    public AssinaturaModel consultaPorCod(long codigo) {
        // Obtém todas as assinaturas
        List<Assinatura> assinaturas = assinaturaJPA.findAll();

        Assinatura assinatura = assinaturas.stream()
                .filter(ass -> ass.getCodigo() == codigo)
                .findFirst()
                .orElse(null);

        if (assinatura == null) {
            throw new IllegalArgumentException("Assinatura não encontrada");
        }

        return Assinatura.toAssinaturaModel(assinatura);
    }

    @Override
    public void salvar(AssinaturaModel assinatura) {
        assinaturaJPA.save(Assinatura.toAssinatura(assinatura));
    }

}
