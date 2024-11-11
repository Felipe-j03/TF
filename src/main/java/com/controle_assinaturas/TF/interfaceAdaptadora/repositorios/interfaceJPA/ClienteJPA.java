package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Cliente;

public interface ClienteJPA extends ListCrudRepository<Cliente, Long> {
    
    
}

