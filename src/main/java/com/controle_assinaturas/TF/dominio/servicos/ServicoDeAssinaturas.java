package com.controle_assinaturas.TF.dominio.servicos;

import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.Assinatura;
import com.controle_assinaturas.TF.dominio.repositorios.IAssinaturaRepositorio;

public class ServicoDeAssinaturas {

    private IAssinaturaRepositorio assinaturas;

    public ServicoDeAssinaturas(IAssinaturaRepositorio assinaturas) {
        this.assinaturas = assinaturas;
    }

    public List<Assinatura> listarAssinaturas() {
        return assinaturas.listarAssinaturas();
    }

    public List<Assinatura> assinaturasValidas(){
        return assinaturas.listarAssinaturasValidas();
    }
 
    public Assinatura consultarPorId(long id){
        return assinaturas.consultaPorCod(id);
    }
    
    
}
