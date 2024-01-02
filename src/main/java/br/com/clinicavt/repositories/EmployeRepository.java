package br.com.clinicavt.repositories;

import br.com.clinicavt.models.employe.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EmployeRepository extends JpaRepository<Employe, UUID> {
}
