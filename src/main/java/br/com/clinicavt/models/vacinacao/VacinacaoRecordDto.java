package br.com.clinicavt.models.vacinacao;

import br.com.clinicavt.models.medicamento.Medicamento;
import br.com.clinicavt.models.pet.Pet;

import java.math.BigDecimal;
import java.util.Date;

public record VacinacaoRecordDto(Pet animal, Medicamento medicamento, Date data, BigDecimal valor, Boolean ativo) {
}
