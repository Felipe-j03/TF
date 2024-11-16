package com.controle_assinaturas.TF.aplicacao.UC;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.controle_assinaturas.TF.aplicacao.dto.AssinaturaDTO;

@Component
public class CriaAssinaturaUC {

    public AssinaturaDTO run(Long codigoCliente, Long codigoAplicativo) {

        long id = new Random().nextLong();
    
        AssinaturaDTO assinatura = new AssinaturaDTO(id, codigoAplicativo, codigoCliente, LocalDate.now(),
                LocalDate.now().plusDays(7), "ATIVA");

        return assinatura;
    }

}
