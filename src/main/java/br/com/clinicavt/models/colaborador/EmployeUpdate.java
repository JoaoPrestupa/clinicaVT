package br.com.clinicavt.models.colaborador;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public record EmployeUpdate(UUID id, String nome, String funcao, BigDecimal salario, Date dataEntrada) {
}
