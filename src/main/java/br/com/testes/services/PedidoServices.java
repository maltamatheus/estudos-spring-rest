package br.com.testes.services;

import br.com.testes.domains.Pedido;
import br.com.testes.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServices {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido(Pedido pedido){
        return salvar(pedido);
    }


    public List<Pedido> obterTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obterPedido(Long id){
        return pedidoRepository.findById(id);
    }

    private Pedido salvar(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
}
