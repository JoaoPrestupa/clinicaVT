package br.com.clinicavt.repositories;

import br.com.clinicavt.infra.models.cirurgia.Cirurgia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface CirurgiaRepository extends JpaRepository<Cirurgia, UUID> {


    Cirurgia cirurgia(Cirurgia cirurgia);
    Cirurgia findCirurgiaByName(String name);
    List<Cirurgia> findAllCirurgia();
    Cirurgia updateCirurgia(Cirurgia cirurgia);
    Cirurgia deleteCirurgia(Integer codigo);

}
