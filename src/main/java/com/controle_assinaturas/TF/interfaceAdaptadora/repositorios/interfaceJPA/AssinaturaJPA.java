package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Assinatura;

public interface AssinaturaJPA extends JpaRepository<Assinatura, Long> {
    List<Assinatura> findByClienteId(Long clienteId);
    List<Assinatura> findByAplicativoId(Long aplicativoId);
}

