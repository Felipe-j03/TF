package com.controle_assinaturas.TF.dominio.repositorios;

import java.util.List;

import com.controle_assinaturas.TF.dominio.entidades.PagamentoModel;

public interface IPagamentoRepositorio {
    
    public List<PagamentoModel> historicoPagamentoPorID(long assinaturaId);
    public void salvar(PagamentoModel pagamento);

}
