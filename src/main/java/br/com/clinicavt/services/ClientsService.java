package br.com.clinicavt.services;

import br.com.clinicavt.models.cliente.Clients;
import br.com.clinicavt.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository repository;

    public List<Clients> getdAll(){
        return repository.findAll();
    }

    public Optional<Clients> getById (UUID id){
        if (!repository.existsById(id)){
            // exception de client not found
        }

        return repository.findById(id);
    }

    public Clients create (Clients cliente){
        return repository.save(cliente);
    }

}
