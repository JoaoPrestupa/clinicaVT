package br.com.clinicavt.models.internacao;

import br.com.clinicavt.models.cliente.Clients;
import br.com.clinicavt.models.medicamento.Medicamento;
import br.com.clinicavt.models.pet.Pet;
import br.com.clinicavt.models.veterinario.Veterinario;

import java.math.BigDecimal;
import java.util.Date;

public record InternacaoRecordDto(Pet animal, Clients cliente, Veterinario veterinario,
                                  Date data, Medicamento medicamento, BigDecimal valor, Boolean ativo) {
}
