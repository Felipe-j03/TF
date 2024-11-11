package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Assinatura;



public interface AssinaturaJPA extends ListCrudRepository<Assinatura, Long> {
    Optional<Assinatura> findByClienteCodigo(Long clienteId);
    Optional<Assinatura> findByAplicativoCodigo(Long aplicativoId);
}
