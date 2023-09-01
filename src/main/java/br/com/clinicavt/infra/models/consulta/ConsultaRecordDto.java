package br.com.clinicavt.infra.models.consulta;

import br.com.clinicavt.infra.models.cliente.Cliente;
import br.com.clinicavt.infra.models.pet.Pet;
import br.com.clinicavt.infra.models.veterinario.Veterinario;

import java.math.BigDecimal;
import java.util.Date;

public record ConsultaRecordDto(Date data, Veterinario veterinario, Cliente cliente, Boolean web, String descricao, Boolean ativo, BigDecimal valor,
                                Boolean cancelada, Pet animal ) {
}
