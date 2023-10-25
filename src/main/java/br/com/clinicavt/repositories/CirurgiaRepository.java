package br.com.clinicavt.repositories;

import br.com.clinicavt.models.cirurgia.Cirurgia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface CirurgiaRepository extends JpaRepository<Cirurgia, UUID> {

    Optional<Cirurgia> findCirurgiaByName (String name);
    Cirurgia updateCirurgia(Cirurgia cirurgia);
    Cirurgia deleteById(Optional<UUID> idCliente);

}
