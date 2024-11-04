package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.JPAImp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.repositorios.IAssinaturaRepositorio;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Assinatura;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA.AplicativoJPA;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA.AssinaturaJPA;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA.ClienteJPA;

@Repository
public class AssinaturaJPAImp implements IAssinaturaRepositorio {

    private final AssinaturaJPA AssinaturaJPA;
    private final AplicativoJPA aplicativoJPA;
    private final ClienteJPA clienteJPA;

    public AssinaturaJPAImp(AssinaturaJPA AssinaturaJPA, AplicativoJPA aplicativoJPA, ClienteJPA clienteJPA) {
        this.AssinaturaJPA = AssinaturaJPA;
        this.aplicativoJPA = aplicativoJPA;
        this.clienteJPA = clienteJPA;
    }
    @Override
    public List<AssinaturaModel> listarAssinaturas(){
        
        List<Assinatura> assinaturas = AssinaturaJPA.findAll();
        
        return assinaturas.stream()
                .map(ass -> Assinatura.toAssinaturaModel(ass))
                .toList();
    }
    @Override
    public List<AssinaturaModel> listarAssinaturaPorCliente(long clienteId){

        List<Assinatura> assinaturas = AssinaturaJPA.findAll();
        
        List<AssinaturaModel> assns = assinaturas.stream()
                .filter(assn -> assn.getCliente().getCodigo() == clienteId);
    }
    @Override
    public List<AssinaturaModel> listarAssinantesPorAplicativo(long aplicativoId){
        return null;
    }
    @Override
    public AssinaturaModel consultaPorCod(long codigo){
        return null;
    }
    @Override
    public void salvar(AssinaturaModel assinatura){
    }
    
    
    

    

    


}
