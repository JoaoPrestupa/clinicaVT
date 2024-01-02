package br.com.clinicavt.services;

import br.com.clinicavt.models.consult.Consult;
import br.com.clinicavt.repositories.ConsultRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsultService {

    @Autowired
    private ConsultRepository repository;

    public List<Consult> getAll(){
        return repository.findAll();
    }

    public Optional<Consult> getById(UUID id){
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("Consulta não encontrada.");
        }
        return repository.findById(id);
    }

    public Consult create(Consult consult){
        return repository.save(consult);
    }
}
