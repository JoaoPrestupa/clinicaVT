package br.com.clinicavt.infra.models.cirurgia;

import br.com.clinicavt.infra.models.cliente.Cliente;
import br.com.clinicavt.infra.models.medicamento.Medicamento;
import br.com.clinicavt.infra.models.pet.Pet;
import br.com.clinicavt.infra.models.veterinario.Veterinario;

import java.math.BigDecimal;
import java.util.Date;

public record DadosAtualizacaoCirurgia(Integer codigo, Pet animal, Cliente cliente,
                                       Veterinario veterinario, Medicamento medicamento, String descricao,
                                       Date data, Boolean ativo, Boolean sucesso, BigDecimal valor) {
}
