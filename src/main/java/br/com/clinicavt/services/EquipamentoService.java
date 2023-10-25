package br.com.clinicavt.services;

import br.com.clinicavt.models.equipamento.Equipamento;
import br.com.clinicavt.repositories.EquipamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    private EquipamentoRepository repository;

    public List<Equipamento> findAllEquipamentos() {
        return repository.findAllEquipamento();
    }

}
