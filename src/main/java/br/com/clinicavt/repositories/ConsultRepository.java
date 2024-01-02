package br.com.clinicavt.repositories;

import br.com.clinicavt.models.consult.Consult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface ConsultRepository extends JpaRepository<Consult, UUID> {
}
