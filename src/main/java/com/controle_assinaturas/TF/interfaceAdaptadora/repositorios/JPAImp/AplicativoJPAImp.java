package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.JPAImp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.repositorios.IAplicativoRepositorio;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Aplicativo;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA.AplicativoJPA;

@Repository
public class AplicativoJPAImp implements IAplicativoRepositorio {

    private final AplicativoJPA aplicativoJPA;

    public AplicativoJPAImp(AplicativoJPA aplicativoJPA) {
        this.aplicativoJPA = aplicativoJPA;
    }

    @Override
    public List<AplicativoModel> listarApps() {
        List<Aplicativo> aplicativos = aplicativoJPA.findAll();
        return aplicativos.stream()
                .map(Aplicativo::toAplicativoModel)
                .toList();

    }

    @Override
    public AplicativoModel consultaPorCod(Long codigo) {
        return aplicativoJPA.findById(codigo)
                .map(Aplicativo::toAplicativoModel)
                .orElse(null);
    }

    @Override
    public void salvar(AplicativoModel aplicativo) {
        Aplicativo appJPA = Aplicativo.toAplicativo(aplicativo);
        aplicativoJPA.save(appJPA);
    }

    public Aplicativo atualizarAplicativo(Long id, Aplicativo novoAplicativo) {
        return aplicativoJPA.findById(id).map(aplicativo -> {
            aplicativo.setNome(novoAplicativo.getNome());
            aplicativo.setCustoMensal(novoAplicativo.getCustoMensal());
            return aplicativoJPA.save(aplicativo);
        }).orElseThrow(() -> new RuntimeException("Aplicativo não encontrado"));
    }

    public void deletarAplicativo(Long id) {
        aplicativoJPA.deleteById(id);
    }

}
