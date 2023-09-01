package br.com.clinicavt.repositories;

import br.com.clinicavt.infra.models.equipamento.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipamentoRepository extends JpaRepository<Equipamento, UUID> {



}
