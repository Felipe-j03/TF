package com.controle_assinaturas.TF.dominio.repositorios;

import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.Pagamento;

public interface IPagamentoRepositorio {
    
    public List<Pagamento> historicoPagamentoPorID(long assinaturaId);
    public void salvar(Pagamento pagamento);

}
