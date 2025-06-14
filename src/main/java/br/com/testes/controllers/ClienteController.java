package br.com.testes.controllers;

import br.com.testes.domains.Cliente;
import br.com.testes.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServices clienteServices;

    @ResponseBody
    @PostMapping("/criar-cliente")
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteServices.criarCliente(cliente));
    }

    @ResponseBody
    @GetMapping("/todos")
    public ResponseEntity<List<Cliente>> obterTodos(){
        return ResponseEntity.ok(clienteServices.obterTodos());
    }

    @ResponseBody
    @GetMapping("/")
    public ResponseEntity<Cliente> obterCliente(@RequestParam Long id){
        Optional<Cliente> clienteOpt = clienteServices.obterCliente(id);

        if (clienteOpt.isPresent()){
            return ResponseEntity.ok(clienteOpt.get());
        }

        return ResponseEntity.notFound().build();
    }
}
