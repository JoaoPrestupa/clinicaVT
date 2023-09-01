package br.com.clinicavt.repositories;

import br.com.clinicavt.infra.models.colaborador.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ColaboradorRepository extends JpaRepository<Colaborador, UUID> {

    //  Consulta insert(Consulta consulta);
    /*
        Consulta findByIdConsulta(UUID id);
    List<Consulta> findAllConsultas();
    Consulta update(Consulta consulta);
    Consulta delete(UUID id);
    */

    Colaborador createColaborador(Colaborador colaborador);
    Colaborador findColaboradorByName(String name);
    Colaborador findAllColaborador();
    Colaborador updateColaborador(Colaborador colaborador);
    Colaborador deleteColaborador(Integer codigo);

}
