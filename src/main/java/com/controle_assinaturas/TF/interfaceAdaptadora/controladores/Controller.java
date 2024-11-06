
package com.controle_assinaturas.TF.interfaceAdaptadora.controladores;

import com.controle_assinaturas.TF.dominio.servicos.AssinaturaServico;
import com.controle_assinaturas.TF.dominio.servicos.ClienteServico;
import com.controle_assinaturas.TF.dominio.servicos.PagamentoServico;
import com.controle_assinaturas.TF.dominio.servicos.AplicativoServico;
import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.entidades.ClienteModel;
import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.entidades.PagamentoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servcad")
public class Controller {

    @Autowired
    private ClienteServico clienteServico;

    @Autowired
    private AplicativoServico aplicativoServico;

    @Autowired
    private AssinaturaServico assinaturaServico;

    @Autowired
    private PagamentoServico pagamentoServico;

    @GetMapping("/clientes")
    public List<ClienteModel> listarClientes() {
        return clienteServico.listarClientes();
    }

    @GetMapping("/aplicativos")
    public List<AplicativoModel> listarAplicativos() {
        return aplicativoServico.listarAplicativos();
    }

    @PostMapping("/assinaturas")
    public ResponseEntity<AssinaturaModel> criarAssinatura(@RequestParam Long codigoCliente, @RequestParam Long codigoAplicativo) {
        AssinaturaModel assinatura = assinaturaServico.criarAssinatura(codigoCliente, codigoAplicativo);
        return ResponseEntity.ok(assinatura);
    }

    @PostMapping("/aplicativos/custo/{idAplicativo}")
    public ResponseEntity<AplicativoModel> atualizarCusto(@PathVariable Long idAplicativo, @RequestBody Double novoCusto) {
        AplicativoModel aplicativo = aplicativoServico.atualizarPrecoApp(idAplicativo, novoCusto);
        return ResponseEntity.ok(aplicativo);
    }

    @GetMapping("/assinaturas/{tipo}")
    public List<AssinaturaModel> listarAssinaturas(@PathVariable String tipo) {
        return assinaturaServico.listarAssinaturasPorTipo(tipo);
    }

    @GetMapping("/clientes/{codcli}/assinaturas")
    public List<AssinaturaModel> listarAssinaturasCliente(@PathVariable Long codcli) {
        return assinaturaServico.listarAssinaturasPorCliente(codcli);
    }

    @GetMapping("/aplicativos/{codapp}/assinaturas")
    public List<AssinaturaModel> listarAssinaturasAplicativo(@PathVariable Long codapp) {
        return assinaturaServico.listarAssinantesPorAplicativo(codapp);
    }

    @PostMapping("/registrarpagamento")
    public ResponseEntity<String> registrarPagamento(@RequestParam Long codass, @RequestParam Double valorPago, 
                                                     @RequestParam int dia, @RequestParam int mes, @RequestParam int ano) {
        return pagamentoServico.registrarPagamento(codass, valorPago, dia, mes, ano);
    }

    @GetMapping("/assinvalida/{codass}")
    public boolean isAssinaturaValida(@PathVariable Long codass) {
        return assinaturaServico.isAssinaturaValida(codass);
    }
}
