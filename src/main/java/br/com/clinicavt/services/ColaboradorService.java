package br.com.clinicavt.services;

import br.com.clinicavt.infra.models.colaborador.Colaborador;
import br.com.clinicavt.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {


    private ColaboradorRepository repository;

    public List<Colaborador> findAllColaborador(){
        return repository.findAllColaborador();
    }

    public Optional<Colaborador> findColaboradorByName(String name){
        return Optional.ofNullable(repository.findColaboradorByName(name)); // lançar exception em caso de erro
    }

    public Colaborador insert (Colaborador colaborador){
        final Optional<Colaborador> colaboradorRecuperado = Optional.ofNullable(repository.findColaboradorByName(colaborador.getNome()));
        if (colaboradorRecuperado.isPresent()){
            // exception
        }
        return repository.insertColaborador(colaborador);
    }

    public Colaborador update(Colaborador colaborador){
        final Optional<Colaborador> colaboradorRecuperdo = Optional.ofNullable(repository.findColaboradorByName(colaborador.getNome()));
        colaborador.setId(colaboradorRecuperdo.get().getId());
        return repository.updateColaborador(colaborador);
    }

    public Colaborador deleteColaborador(Integer codigo){
        return repository.deleteColaborador(codigo);
    }


}
