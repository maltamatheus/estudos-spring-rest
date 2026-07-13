package br.com.estudos.services;

import br.com.estudos.domains.Cliente;
import br.com.estudos.domains.Pedido;
import br.com.estudos.domains.dto.request.PedidoDTO;
import br.com.estudos.mappers.PedidoMapper;
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

    private PedidoMapper pedidoMapper;

    public Pedido criarPedido(PedidoDTO dto){
        return salvar(dto);
    }

    public List<Pedido> obterTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obterPedido(Long id){
        return pedidoRepository.findById(id);
    }

    private Pedido salvar(PedidoDTO dto){
        if(dto.getCliente() == null){
            throw new RuntimeException("Todo pedido precisa ter um cliente");
        }

        return pedidoRepository.save(pedidoMapper.toEntity(dto));
    }
}
