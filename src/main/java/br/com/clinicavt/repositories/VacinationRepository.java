package br.com.clinicavt.repositories;

import br.com.clinicavt.models.vacination.VacinationEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VacinationRepository extends JpaRepository<VacinationEmbeddable, UUID> {
}
