package br.com.clinicavt.models.veterinarian;

import br.com.clinicavt.models.AdressesEmbeddable;

import java.math.BigDecimal;
import java.util.Date;

public record VeterinarianDto(String name, String crmv, String email, AdressesEmbeddable adress, Date data, BigDecimal salary) {
}
