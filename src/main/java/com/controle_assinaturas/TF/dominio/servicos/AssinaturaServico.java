package com.controle_assinaturas.TF.dominio.servicos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cglib.core.Local;

import com.controle_assinaturas.TF.dominio.entidades.Aplicativo;
import com.controle_assinaturas.TF.dominio.entidades.Assinatura;
import com.controle_assinaturas.TF.dominio.entidades.Cliente;
import com.controle_assinaturas.TF.dominio.repositorios.IAssinaturaRepositorio;

public class AssinaturaServico {

    private IAssinaturaRepositorio assinaturaRepositorio;

    public AssinaturaServico(IAssinaturaRepositorio assinaturaRepositorio) {
        this.assinaturaRepositorio = assinaturaRepositorio;
    }

    public List<Assinatura> listarAssinaturas() {
        return assinaturaRepositorio.listarAssinaturas();
    }

    public List<Assinatura> assinaturasValidas() {
        return assinaturaRepositorio.listarAssinaturasValidas();
    }

    public Assinatura consultarPorId(long id) {
        return assinaturaRepositorio.consultaPorCod(id);
    }

    public void cadastrarAssinatura(long id, Cliente cliente, Aplicativo aplicativo) {
        Assinatura assinatura = new Assinatura(id, LocalDate.now(), LocalDate.now().plusDays(7), aplicativo, cliente);
        assinaturaRepositorio.salvar(assinatura);
    }

    public boolean isAssinaturaValida(Assinatura assinatura) {
        return assinatura.getFimVigencia().isAfter(LocalDate.now());
    }
    
    public List<Assinatura> listarAssinaturasPorCliente(Cliente cliente){
        return assinaturaRepositorio.listarAssinaturaPorCliente(cliente);
    }
    
    public List<Assinatura> listarAssinantesPorAplicativo(Aplicativo aplicativo){
        return assinaturaRepositorio.listarAssinantesPorAplicativo(aplicativo);
    }

}
