package br.com.clinicavt.services;

import br.com.clinicavt.models.vacination.Vacination;
import br.com.clinicavt.repositories.VacinationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VacinationService {

    @Autowired
    private VacinationRepository repository;

    public List<Vacination> getAll(){
        return repository.findAll();
    }

    public Optional<Vacination> getById(UUID id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("ID não existente");
        }
        return repository.findById(id);
    }

    public Vacination create(Vacination vacination){
        return repository.save(vacination);
    }
}
