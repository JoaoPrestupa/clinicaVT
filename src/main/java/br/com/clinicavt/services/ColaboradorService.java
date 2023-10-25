package br.com.clinicavt.services;

import br.com.clinicavt.models.colaborador.Colaborador;
import br.com.clinicavt.repositories.ColaboradorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ColaboradorService {


    private ColaboradorRepository repository;
    private Colaborador model;

    public List<Colaborador> findAllColaborador(){
        return repository.findAll();
    }

    public Optional<Colaborador> findColaboradorByName(String name){                                    // exception

        Optional<Colaborador> colaboradorRecuperado = Optional.of(repository.findColaboradorByName(name).orElseThrow());

        return colaboradorRecuperado;
    }

    public Colaborador insert (Colaborador colaborador){
        final boolean colaboradorRecuperado = repository.existsById(colaborador.getId());
        if (colaboradorRecuperado == true){
            // exception
        }
        return repository.save(colaborador);
    }

    public Colaborador update(UUID id, Colaborador colaborador){
        final Optional<Colaborador> colaboradorRecuperdo = Optional.of(repository.getReferenceById(id));
        if (colaboradorRecuperdo.isEmpty()) {
            // exception
        }
        return repository.updateColaborador(colaborador);
    }

    public Colaborador delete(UUID id){
        Optional<Colaborador> colaborador = repository.getReferenceById(id).setAtivo(false); // lançar exception

        return repository.deleteColaborador(id);
    }


}
