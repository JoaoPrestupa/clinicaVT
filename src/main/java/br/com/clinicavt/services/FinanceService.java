package br.com.clinicavt.services;

import br.com.clinicavt.models.finance.Finance;
import br.com.clinicavt.repositories.FinanceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FinanceService {

    @Autowired
    private FinanceRepository repository;

    public List<Finance> getAll(){
        return repository.findAll();
    }

    public Optional<Finance> getById(UUID id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("ID inexistente ou inválido.");
        }
        return repository.findById(id);
    }

    public Finance create(Finance finance){
        return repository.save(finance);
    }

}
