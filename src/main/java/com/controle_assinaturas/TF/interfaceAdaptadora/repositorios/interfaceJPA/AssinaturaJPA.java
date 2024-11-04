package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Assinatura;

public interface AssinaturaJPA extends JpaRepository<Assinatura, Long> {
    Optional<Assinatura> findById(Long codigo);
    Optional<Assinatura> findByClienteId(Long clienteId);
    Optional<Assinatura> findByAplicativoId(Long aplicativoId);
}

