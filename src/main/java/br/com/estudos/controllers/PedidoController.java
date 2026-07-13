package br.com.estudos.controllers;

import br.com.estudos.domains.Pedido;
import br.com.estudos.domains.dto.request.PedidoDTO;
import br.com.estudos.services.PedidoServices;
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
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoDTO pedidoDTO){
        return ResponseEntity.ok(pedidoServices.criarPedido(pedidoDTO));
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
