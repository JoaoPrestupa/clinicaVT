package br.com.clinicavt.repositories;

import br.com.clinicavt.infra.models.medicamento.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicamentoRepository extends JpaRepository<Medicamento, UUID> {



}
