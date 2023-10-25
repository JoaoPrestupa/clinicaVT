package br.com.clinicavt.repositories;

import br.com.clinicavt.models.medicamento.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicamentoRepository extends JpaRepository<Medicamento, UUID> {


    Medicamento insertMedicamento(Medicamento medicamento);
    Optional<Medicamento> findMedicamentoByName(String Nome);
    List<Medicamento> findAllMedicamento();
    Medicamento updateMedicamento(Medicamento medicamento);
    Medicamento delete(Integer codigo);

}
