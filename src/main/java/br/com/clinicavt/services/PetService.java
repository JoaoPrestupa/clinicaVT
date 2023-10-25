package br.com.clinicavt.services;

import br.com.clinicavt.models.pet.Pet;
import br.com.clinicavt.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List<Pet> findAll(){
        return repository.findAll();
    }

    public Optional<Pet> getById (UUID id){
        if (!repository.existsById(id)){
            // exception de pet not found
        }
        return repository.findById(id);
    }

    public Pet create(Pet pet){
        return repository.save(pet);
    }

}

