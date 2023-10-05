package br.com.clinicavt.services;

import br.com.clinicavt.infra.models.cliente.Cliente;
import br.com.clinicavt.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private ClienteRepository repository;

    public List<Cliente> findAllClientes(){
        return repository.findAllClientes();
    }

    public Optional<Cliente> findClienteByName(String name){
        return repository.findClienteByName(name); //
    }

    public Cliente createCliente(Cliente cliente){
        final Optional<Cliente> clienteRecuperado = repository.findClienteByName(cliente.getNome());

        if (clienteRecuperado.isPresent()){
            // jogar exception
        }
        return repository.createCliente(cliente);
    }

    public Cliente update(Cliente cliente){
        final Optional<Cliente> clienteRecuperado = repository.findClienteByName(cliente.getNome());

        cliente.setId(clienteRecuperado.get().getId());

        return repository.updateCliente(cliente);
    }

    public Cliente delete(Integer codigo){
        return repository.deleteCliente(codigo);
    }



}
