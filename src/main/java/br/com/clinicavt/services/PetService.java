package br.com.clinicavt.services;

import br.com.clinicavt.models.pet.Pet;
import br.com.clinicavt.models.vacination.VacinationDto;
import br.com.clinicavt.models.vacination.VacinationEmbeddable;
import br.com.clinicavt.repositories.PetRepository;
import br.com.clinicavt.repositories.VacinationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    @Autowired
    private VacinationRepository vacinationRepository;

    public List<Pet> findAll(){
        return repository.findAll();
    }

    public Optional<Pet> getById (UUID id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("ID inexistente ou inválido.");
        }
        return repository.findById(id);
    }

    public Pet create(Pet pet){
        return repository.save(pet);
    }

    public void vacinar(UUID id, VacinationEmbeddable dto){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("ID inexistente ou inválido.");
        }
        Pet pet =
                repository.getReferenceById(id);
        pet.vacinar(dto);
    }

}


