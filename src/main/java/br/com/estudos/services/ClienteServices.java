package br.com.estudos.services;

import br.com.estudos.domains.Cliente;
import br.com.estudos.domains.dto.request.ClienteDTO;
import br.com.estudos.mappers.ClienteMapper;
import br.com.estudos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServices {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public Cliente criarCliente(Cliente cliente){
        Cliente novoCliente = salvar(cliente);
//        ClienteDTO clienteDTO = clienteMapper.toDto(novoCliente);
        return novoCliente;
    }

    private Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obterTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obterCliente(Long id){
        return clienteRepository.findById(id);
    }
}
