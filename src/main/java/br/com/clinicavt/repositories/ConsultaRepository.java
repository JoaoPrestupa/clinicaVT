package br.com.clinicavt.repositories;

import br.com.clinicavt.models.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {

    Optional<Consulta> findByCodigo(Integer codigo);

    Consulta insertConsulta(Consulta consulta);

    List<Consulta> findAllConsulta();

    Consulta updateConsulta(Consulta consulta);

    Consulta deleteConsulta(Integer codigo);


}
