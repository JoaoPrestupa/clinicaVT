package br.com.clinicavt.models.veterinarian;

import br.com.clinicavt.models.medicamento.Medicamento;
import br.com.clinicavt.models.pet.Pet;
import br.com.clinicavt.models.veterinario.EnderecoEmbeddable;

import java.math.BigDecimal;
import java.util.Date;

public record VeterinarianDto(String name, String crmv, String email, EnderecoEmbeddable adress, Date data, BigDecimal salary) {
}
