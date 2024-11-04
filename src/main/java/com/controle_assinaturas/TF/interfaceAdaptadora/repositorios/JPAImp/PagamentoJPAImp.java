package com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.JPAImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.controle_assinaturas.TF.dominio.entidades.PagamentoModel;
import com.controle_assinaturas.TF.dominio.repositorios.IPagamentoRepositorio;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Assinatura;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.entidades.Pagamento;
import com.controle_assinaturas.TF.interfaceAdaptadora.repositorios.interfaceJPA.PagamentoJPA;

@Repository
public class PagamentoJPAImp implements IPagamentoRepositorio {

    private final PagamentoJPA pagamentoJPA;

    public PagamentoJPAImp(PagamentoJPA pagamentoJPA) {
        this.pagamentoJPA = pagamentoJPA;
    }

    @Override
    public List<PagamentoModel> historicoPagamentoPorID(long assinaturaId) {
        // Obtém todos os pagamentos
        List<Pagamento> pagamentos = pagamentoJPA.findAll();

        // Filtra pagamentos pelo assinaturaId e converte para PagamentoModel
        List<PagamentoModel> pagamentosModel = pagamentos.stream()
                .filter(pagamento -> pagamento.getAssinatura().getCodigo() == assinaturaId) // Filtra por assinaturaId
                .map(Pagamento::toPagamentoModel) // Converte para PagamentoModel usando o método toPagamentoModel
                .collect(Collectors.toList());

        return pagamentosModel;
    }

    @Override
    public void salvar(PagamentoModel pagamento) {
        pagamentoJPA.save(Pagamento.toPagamento(pagamento));
    }

}
