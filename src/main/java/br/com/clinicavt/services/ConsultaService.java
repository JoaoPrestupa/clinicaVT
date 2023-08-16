package br.com.clinicavt.services;

import br.com.clinicavt.infra.models.consulta.Consulta;
import br.com.clinicavt.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    public List<Consulta> findAllConsultas(){
        return repository.findAllConsultas();
    }

    public Consulta findById(UUID id){
        return repository.findByIdConsulta(id); //lançaria uma excessao em caso de erro
    }

    public Consulta insert(Consulta consulta){
        final Optional<Consulta> consultaRecuperada = repository.findById(consulta.getIdConsulta());

        if (consultaRecuperada.isPresent()){
            // excessao lançada
        }
        return repository.insert(consulta);
    }

    public Consulta update(Consulta consulta){
        final Consulta consultaRecuperada = repository.findByIdConsulta(consulta.getIdConsulta());//lançaria excessao em caso de erro
        consulta.setIdConsulta(consultaRecuperada.getIdConsulta());
        return repository.update(consulta);
    }

    public Consulta delete(UUID id){
        return repository.delete(id);
    }

}
