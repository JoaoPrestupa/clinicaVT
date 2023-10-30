package br.com.clinicavt.services;

import br.com.clinicavt.models.cliente.Client;
import br.com.clinicavt.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public List<Client> getdAll(){
        return repository.findAll();
    }

    public Optional<Client> getById (UUID id){
        if (!repository.existsById(id)){
            // exception de client not found
        }

        return repository.findById(id);
    }

    public Client create (Client cliente){
        return repository.save(cliente);
    }

}
