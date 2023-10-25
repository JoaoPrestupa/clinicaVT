package br.com.clinicavt.models.consulta;

import br.com.clinicavt.models.cliente.Clients;
import br.com.clinicavt.models.pet.Pet;
import br.com.clinicavt.models.veterinario.Veterinario;

import java.math.BigDecimal;
import java.util.Date;

public record DadosAtualizacaoConsulta(Date data, Veterinario veterinario, Clients cliente, Boolean web, String descricao, Boolean ativo, BigDecimal valor,
                                       Boolean cancelada, Pet animal ) {
}
