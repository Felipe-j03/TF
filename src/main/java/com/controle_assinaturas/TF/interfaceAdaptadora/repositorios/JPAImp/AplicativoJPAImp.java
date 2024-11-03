package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.JPAImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.controle_assinaturas.TF.dominio.repositorios.IAplicativoRepositorio;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Aplicativo;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA.AplicativoJPA;

@Service
public class AplicativoJPAImp implements IAplicativoRepositorio {

    private final AplicativoJPA aplicativoJPA;

    @Autowired
    public AplicativoJPAImp(AplicativoJPA aplicativoReposito) {
        this.aplicativoJPA = aplicativoJPA;
    }

    public Aplicativo criarAplicativo(Aplicativo aplicativo) {
        return aplicativoJPA.salvar(aplicativo);
    }

    public List<Aplicativo> listarAplicativos() {
        return aplicativoJPA.findAll();
    }

    public Optional<Aplicativo> buscarAplicativoPorId(Long id) {
        return aplicativoJPA.findBy(id).orElse(null);
    }

    public Aplicativo atualizarAplicativo(Long id, Aplicativo novoAplicativo) {
        return aplicativoJPA.findById(id).map(aplicativo -> {
            aplicativo.setNome(novoAplicativo.getNome());
            aplicativo.setPrecoMensal(novoAplicativo.getPrecoMensal());
            return aplicativoJPA.save(aplicativo);
        }).orElseThrow(() -> new RuntimeException("Aplicativo não encontrado"));
    }

    public void deletarAplicativo(Long id) {
        aplicativoJPA.deleteById(id);
    }
}

