package br.com.clinicavt.repositories;

import br.com.clinicavt.models.colaborador.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, UUID> {

    Colaborador insertColaborador(Colaborador colaborador);
    Optional<Colaborador> findColaboradorByName(String name);
    List<Colaborador> findAllColaborador();

    Colaborador updateColaborador(Colaborador colaborador);

    Colaborador deleteColaborador(UUID id);

}
