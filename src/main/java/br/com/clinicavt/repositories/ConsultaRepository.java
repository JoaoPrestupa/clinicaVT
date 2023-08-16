package br.com.clinicavt.repositories;

import br.com.clinicavt.infra.models.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {

    Consulta insert(Consulta consulta);
    Consulta findByIdConsulta(UUID id);
    List<Consulta> findAllConsultas();
    Consulta update(Consulta consulta);
    Consulta delete(UUID id);

}
