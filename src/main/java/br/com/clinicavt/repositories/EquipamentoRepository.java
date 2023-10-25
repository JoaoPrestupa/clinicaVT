package br.com.clinicavt.repositories;

import br.com.clinicavt.models.equipamento.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EquipamentoRepository extends JpaRepository<Equipamento, UUID> {

    Equipamento inserEquipamento(Equipamento equipamento);
    Equipamento findEquipamentoByCodigo(Integer codigo);
    List<Equipamento> findAllEquipamento();
    Equipamento updateEquipamento(Equipamento equipamento);
    Equipamento deleteEquipamento(Integer codigo);

}
