package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Pagamento;


public interface PagamentoJPA extends ListCrudRepository<Pagamento, Long> {

    Optional<Pagamento> findByCodigo(Long pagamentoId);
}
