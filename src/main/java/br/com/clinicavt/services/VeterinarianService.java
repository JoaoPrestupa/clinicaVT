package br.com.clinicavt.services;

import br.com.clinicavt.models.adresses.AdressesEmbeddable;
import br.com.clinicavt.models.adresses.AdressesUpdate;
import br.com.clinicavt.models.veterinarian.Veterinanian;
import br.com.clinicavt.repositories.VeterinarianRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VeterinarianService {

    @Autowired
    private VeterinarianRepository repository;

    public List<Veterinanian> getAll(){
        return repository.findAll();
    }

    public Optional<Veterinanian> getById(UUID id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("ID inexistente.");
        }

        return repository.findById(id);
    }

    public Veterinanian create (@Valid Veterinanian veterinanian){
        return repository.save(veterinanian);
    }

    public void update_adresses(UUID id, AdressesUpdate adressesUpdate) {
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("ID inexistente ou inválido.");
        }
        AdressesEmbeddable newAdress = new AdressesEmbeddable();
        newAdress.adressesUpdate(adressesUpdate);
        repository.findById(id).get().setAdress(newAdress);
    }
}
