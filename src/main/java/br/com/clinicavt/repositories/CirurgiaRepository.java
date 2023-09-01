package br.com.clinicavt.repositories;

import br.com.clinicavt.infra.models.cirurgia.Cirurgia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CirurgiaRepository extends JpaRepository<Cirurgia, UUID> {



}
