package br.com.testes.controllers;

import br.com.testes.domains.Pedido;
import br.com.testes.services.PedidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoServices pedidoServices;

    @ResponseBody
    @PostMapping("/criar-pedido")
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido){
        return ResponseEntity.ok(pedidoServices.criarPedido(pedido));
    }

    @ResponseBody
    @GetMapping("/todos")
    public ResponseEntity<List<Pedido>> obterTodos(){
        return ResponseEntity.ok(pedidoServices.obterTodos());
    }

    @ResponseBody
    @GetMapping("/")
    public ResponseEntity<Pedido> obterPedido(@RequestParam Long id){
        Optional<Pedido> pedidoOpt = pedidoServices.obterPedido(id);

        if (pedidoOpt.isPresent()){
            return ResponseEntity.ok(pedidoOpt.get());
        }

        return ResponseEntity.notFound().build();
    }
}
