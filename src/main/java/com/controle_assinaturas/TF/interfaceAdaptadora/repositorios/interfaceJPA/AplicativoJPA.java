package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Aplicativo;

public interface AplicativoJPA extends ListCrudRepository<Aplicativo, Long> {
    
    
   
}

