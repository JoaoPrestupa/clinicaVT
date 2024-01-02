package br.com.clinicavt.repositories;

import br.com.clinicavt.models.vacination.Vacination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VacinationRepository extends JpaRepository<Vacination, UUID> {
}
