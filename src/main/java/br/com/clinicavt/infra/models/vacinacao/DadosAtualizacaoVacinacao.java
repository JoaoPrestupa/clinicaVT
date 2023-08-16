package br.com.clinicavt.infra.models.vacinacao;

import br.com.clinicavt.infra.models.medicamento.Medicamento;
import br.com.clinicavt.infra.models.pets.Pet;

import java.math.BigDecimal;
import java.util.Date;

public record DadosAtualizacaoVacinacao(Pet animal, Medicamento medicamento, Date data, BigDecimal valor) {
}
