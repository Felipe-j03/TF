package com.controle_assinaturas.TF.interfaceAdaptadora.controladores;

import com.controle_assinaturas.TF.dominio.entidades.AssinaturaModel;
import com.controle_assinaturas.TF.dominio.entidades.ClienteModel;
import com.controle_assinaturas.TF.aplicacao.UC.CriaAssinaturaUC;
import com.controle_assinaturas.TF.aplicacao.UC.ListaPorTipoUC;
import com.controle_assinaturas.TF.aplicacao.UC.ListaPorTipoUC;
import com.controle_assinaturas.TF.aplicacao.dto.AssinaturaDTO;
import com.controle_assinaturas.TF.dominio.entidades.AplicativoModel;
import com.controle_assinaturas.TF.dominio.entidades.PagamentoModel;
import com.controle_assinaturas.TF.dominio.servicos.AssinaturaServico;
import com.controle_assinaturas.TF.dominio.servicos.ClienteServico;
import com.controle_assinaturas.TF.dominio.servicos.PagamentoServico;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;
import com.controle_assinaturas.TF.dominio.servicos.AplicativoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private CriaAssinaturaUC criaAssinaturaUC;

    @Autowired
    private ListaPorTipoUC listaPorTipoUC;

    public Controller(ClienteServico clienteServico, AplicativoServico aplicativoServico,
            AssinaturaServico assinaturaServico, PagamentoServico pagamentoServico, CriaAssinaturaUC criaAssinaturaUC,
            ListaPorTipoUC listaPorTipoUC) {
        this.clienteServico = clienteServico;
        this.aplicativoServico = aplicativoServico;
        this.assinaturaServico = assinaturaServico;
        this.pagamentoServico = pagamentoServico;
        this.criaAssinaturaUC = criaAssinaturaUC;
        this.listaPorTipoUC = listaPorTipoUC;
    }

    @GetMapping("")
    public String welcomeMessage() {
        return ("Bem vindo ao Controle de Assinaturas");
    }

    @GetMapping("/clientes")
    public List<ClienteModel> listarClientes() {
        return clienteServico.listarClientes();
    }

    @GetMapping("/aplicativos")
    public List<AplicativoModel> listarAplicativos() {
        return aplicativoServico.listarAplicativos();
    }

    @PostMapping("/assinaturas")
    public ResponseEntity<AssinaturaDTO> criarAssinatura(@RequestParam Long codigoCliente,
            @RequestParam Long codigoAplicativo) {
        AssinaturaDTO assinatura = criaAssinaturaUC.run(codigoCliente, codigoAplicativo);
        return ResponseEntity.ok(assinatura);
    }

    @PostMapping("/aplicativos/custo/{idAplicativo}")
    public ResponseEntity<AplicativoModel> atualizarCusto(@PathVariable Long idAplicativo,
            @RequestBody Double novoCusto) {
        AplicativoModel aplicativo = aplicativoServico.atualizarPrecoApp(idAplicativo, novoCusto);
        return ResponseEntity.ok(aplicativo);
    }

    @GetMapping("/assinaturas/{tipo}")
    public ResponseEntity<List<AssinaturaDTO>> listarAssinaturasPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(listaPorTipoUC.run(tipo));
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
        return ResponseEntity.ok(pagamentoServico.registrarPagamento(codass, valorPago, dia, mes, ano));
    }

    @GetMapping("/assinvalida/{codass}")
    public boolean isAssinaturaValida(@PathVariable Long codass) {
        return assinaturaServico.isAssinaturaValida(assinaturaServico.consultaPorCodigo(codass));
    }

}
