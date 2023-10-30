package br.com.clinicavt.models.cirurgia;

import br.com.clinicavt.models.cliente.Client;
import br.com.clinicavt.models.medicamento.Medicamento;
import br.com.clinicavt.models.pet.Pet;
import br.com.clinicavt.models.veterinario.Veterinario;

import java.math.BigDecimal;
import java.util.Date;

public record CirurgiaRecordDto(Pet animal, Client cliente, Veterinario veterinario,
                                Medicamento medicamento, String descricao, Date data,
                                Boolean ativo, Boolean sucesso, BigDecimal valor, Integer codigo) {
}
