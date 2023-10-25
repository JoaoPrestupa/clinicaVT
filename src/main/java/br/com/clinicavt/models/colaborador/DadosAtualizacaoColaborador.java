package br.com.clinicavt.models.colaborador;

import br.com.clinicavt.models.veterinario.Veterinario;

import java.math.BigDecimal;
import java.util.Date;

public record DadosAtualizacaoColaborador(String nome, String funcao, BigDecimal salario,
                                          Veterinario veterinario, Date dataEntrada, Boolean ativo) {
}
