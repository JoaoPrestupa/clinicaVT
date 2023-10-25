package br.com.clinicavt.services;

import br.com.clinicavt.models.consulta.Consulta;
import br.com.clinicavt.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private Consulta consultaBD;

    public List<Consulta> findAllConsultas(){
        return repository.findAll();
    }

    public Optional<Integer> findByCodigo(Integer codigo){
        return Optional.ofNullable(consultaBD.getCodigo());
    }

    public Consulta insert(Consulta consulta){
        final Optional<Consulta> consultaRecuperado = repository.findByCodigo(consulta.getCodigo());
        if (consultaRecuperado.isPresent()){
            // jogar uma exception
        }
        return repository.save(consulta);
    }

    public Consulta update(Consulta consulta){
        final Optional<Consulta> consultaRecuperado = repository.findByCodigo(consulta.getCodigo());

        consulta.setId(consultaRecuperado.orElseThrow().getId());

        return repository.updateConsulta(consulta);

    }

    public Consulta deleteByCodigo(Integer codigo){
        return repository.deleteConsulta(codigo); // lançar exception em caso de consulta n encontrada
    }


}
