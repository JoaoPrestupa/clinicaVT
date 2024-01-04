package br.com.clinicavt.models.employe;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public record EmployeDto(Date dataEntrada, String nome, String funcao, BigDecimal salario, Boolean ativo) {
}
