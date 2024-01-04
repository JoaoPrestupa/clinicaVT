package br.com.clinicavt.models.veterinarian;

import br.com.clinicavt.models.adresses.AdressesEmbeddable;

import java.math.BigDecimal;
import java.util.UUID;

public record VeterinarianUpdate(UUID id, String name, String email, String crmv, BigDecimal salary, VeterinarianDetails veterinanDetails) {
}
