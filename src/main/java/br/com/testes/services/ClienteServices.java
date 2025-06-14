package br.com.testes.services;

import br.com.testes.domains.Cliente;
import br.com.testes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServices {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente){
        return salvar(cliente);
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
