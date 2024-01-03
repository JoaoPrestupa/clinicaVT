package br.com.clinicavt.services;

import br.com.clinicavt.models.client.Client;
import br.com.clinicavt.models.client.ClientDto;
import br.com.clinicavt.repositories.ClientRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public List<Client> getAll(){
        return repository.findAll();
    }

    public Optional<Client> getById (UUID id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("ID inexistente");
        }

        return repository.findById(id);
    }

    public Client create (Client cliente){
        if (repository.equals(cliente.getCpf()) ){
            throw new EntityExistsException("CPF já cadastrado. "); // criar uma exception especifica
        }
        return repository.save(cliente);
    }

}
