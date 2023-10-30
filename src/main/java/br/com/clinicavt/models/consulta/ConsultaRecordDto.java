package br.com.clinicavt.models.consulta;

import br.com.clinicavt.models.cliente.Client;
import br.com.clinicavt.models.pet.Pet;
import br.com.clinicavt.models.veterinario.Veterinario;

import java.math.BigDecimal;
import java.util.Date;

public record ConsultaRecordDto(Date data, Veterinario veterinario, Client cliente, Boolean web, String descricao, Boolean ativo, BigDecimal valor,
                                Boolean cancelada, Pet animal ) {
}
