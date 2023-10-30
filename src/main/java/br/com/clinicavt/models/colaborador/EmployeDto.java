package br.com.clinicavt.models.colaborador;

import java.math.BigDecimal;
import java.util.Date;

public record EmployeDto(Date dataEntrada, String nome, String funcao, BigDecimal salario, Boolean ativo) {
}
