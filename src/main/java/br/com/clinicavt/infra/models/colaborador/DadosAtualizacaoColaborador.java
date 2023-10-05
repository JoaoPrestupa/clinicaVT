package br.com.clinicavt.infra.models.colaborador;

import br.com.clinicavt.infra.models.veterinario.Veterinario;

import java.math.BigDecimal;
import java.util.Date;

public record DadosAtualizacaoColaborador(String nome, String funcao, BigDecimal salario,
                                          Veterinario veterinario, Date dataEntrada) {
}
