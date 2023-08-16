package br.com.clinicavt.infra.dto;

import br.com.clinicavt.infra.models.veterinario.Veterinario;

import java.math.BigDecimal;

public record ColaboradorRecordDto(Integer codigo, String nome, String funcao, BigDecimal salario, Veterinario veterinario) {
}
