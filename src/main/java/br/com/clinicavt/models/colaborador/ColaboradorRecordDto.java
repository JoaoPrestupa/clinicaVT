package br.com.clinicavt.models.colaborador;

import br.com.clinicavt.models.veterinario.Veterinario;

import java.math.BigDecimal;
import java.util.Date;

public record ColaboradorRecordDto(Date dataEntrada, String nome, String funcao, BigDecimal salario, Veterinario veterinario, Boolean ativo) {
}
