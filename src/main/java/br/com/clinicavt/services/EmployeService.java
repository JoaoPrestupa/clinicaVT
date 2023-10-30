package br.com.clinicavt.services;

import br.com.clinicavt.models.colaborador.Employe;
import br.com.clinicavt.repositories.EmployeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepository repository;

    public List<Employe> getAll(){
        return repository.findAll();
    }

    public Optional<Employe> getById(UUID id){
        if (repository.findById(id).isEmpty()){
            throw new EntityNotFoundException("ID inexistente ou não encontrado");
        }
        return repository.findById(id);
    }

    public Employe create (Employe colaborador){
        return repository.save(colaborador);
    }

}
