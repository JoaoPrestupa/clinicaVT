package br.com.clinicavt.infra.models.colaborador;

import br.com.clinicavt.infra.models.veterinario.Veterinario;

import java.math.BigDecimal;

public record DadosAtualizacaoColaborador(Integer codigo, String nome, String funcao, BigDecimal salario, Veterinario veterinario) {
}
