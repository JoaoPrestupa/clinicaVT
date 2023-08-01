package br.com.clinicavt.repositories;

import br.com.clinicavt.models.VeterinarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VeterinarioRepository extends JpaRepository<VeterinarioModel, UUID> {
}
