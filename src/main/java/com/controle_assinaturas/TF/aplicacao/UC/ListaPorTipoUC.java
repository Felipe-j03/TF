package com.controle_assinaturas.TF.aplicacao.UC;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.controle_assinaturas.TF.aplicacao.dto.AssinaturaDTO;
import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.repositorios.IAssinaturaRepositorio;

@Component
public class ListaPorTipoUC {

    private final IAssinaturaRepositorio assinaturaRepositorio;

    public ListaPorTipoUC(IAssinaturaRepositorio assinaturaRepositorio) {
        this.assinaturaRepositorio = assinaturaRepositorio;
    }

    public List<AssinaturaDTO> run(String tipo) {
        // Consulta as assinaturas (filtra no repositório)
        List<AssinaturaModel> assinaturas = assinaturaRepositorio.listarAssinaturas();
        List<AssinaturaDTO> assn = new LinkedList<>();

        if (tipo.equals("ATIVAS")) {
            assn = assinaturas.stream()
                    .filter(assinatura -> assinatura.getFimVigencia().isAfter(LocalDate.now()))
                    .map(ass -> new AssinaturaDTO(ass.getCodigo(),
                            ass.getAplicativo().getCodigo(),
                            ass.getCliente().getCodigo(),
                            ass.getInicioVigencia(),
                            ass.getFimVigencia(),
                            "ATIVA"))
                    .collect(Collectors.toList());
        } else if (tipo.equals("CANCELADAS")) {
            assn = assinaturas.stream()
                    .filter(assinatura -> assinatura.getFimVigencia().isBefore(LocalDate.now()))
                    .map(ass -> new AssinaturaDTO(ass.getCodigo(),
                            ass.getAplicativo().getCodigo(),
                            ass.getCliente().getCodigo(),
                            ass.getInicioVigencia(),
                            ass.getFimVigencia(),
                            "CANCELADA"))
                    .collect(Collectors.toList());
        } else if (tipo.equals("TODAS")) {
            assn = assinaturas.stream()
                    .map(ass -> {
                        // Exibe a data de comparação e o status calculado
                        String status = ass.getFimVigencia().isAfter(LocalDate.now()) ? "ATIVA" : "CANCELADA";
                        System.out.println("Fim Vigência: " + ass.getFimVigencia() + " Data Atual: " + LocalDate.now()
                                + " status: " + status);

                        return new AssinaturaDTO(
                                ass.getCodigo(),
                                ass.getAplicativo().getCodigo(),
                                ass.getCliente().getCodigo(),
                                ass.getInicioVigencia(),
                                ass.getFimVigencia(),
                                status);
                    })
                    .collect(Collectors.toList());

        }
        return assn;

    }
}
