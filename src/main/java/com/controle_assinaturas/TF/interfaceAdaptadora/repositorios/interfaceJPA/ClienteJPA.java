package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Cliente;

public interface ClienteJPA extends JpaRepository<Cliente, Long> {
    
}

