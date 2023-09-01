package br.com.clinicavt.infra.models.internacao;

import br.com.clinicavt.infra.models.cliente.Cliente;
import br.com.clinicavt.infra.models.medicamento.Medicamento;
import br.com.clinicavt.infra.models.pet.Pet;
import br.com.clinicavt.infra.models.veterinario.Veterinario;

import java.math.BigDecimal;
import java.util.Date;

public record DadosAtualizacaoInternacao(Pet animal, Cliente cliente, Veterinario veterinario,
                                         Date data, Medicamento medicamento, BigDecimal valor) {
}
