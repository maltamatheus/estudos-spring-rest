package br.com.estudos.services;

import br.com.estudos.domains.Cliente;
import br.com.estudos.domains.Pedido;
import br.com.estudos.repositories.ClienteRepository;
import br.com.estudos.repositories.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PedidoServices {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

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
        if(pedido.getCliente().getId() == null || clienteRepository.findById(pedido.getCliente().getId()).isEmpty()){
            pedido.getCliente().setId(clienteRepository.save(pedido.getCliente()).getId());
        }
        return pedidoRepository.save(pedido);
    }
}
