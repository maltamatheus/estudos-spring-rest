package br.com.estudos.services;

import br.com.estudos.domains.Cliente;
import br.com.estudos.domains.dto.request.ClienteDto;
import br.com.estudos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServices {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(ClienteDto dto){
        return salvar(dtoToEntity(dto));
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

    private Cliente dtoToEntity(ClienteDto dto){
        return new Cliente(dto.getNome(),dto.getDataNascto());
    }
}
