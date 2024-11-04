package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Pagamento;

public interface PagamentoJPA extends JpaRepository<Pagamento, Long> {

    Optional<Pagamento> findByPagamentoId(Long pagamentoId);
}
