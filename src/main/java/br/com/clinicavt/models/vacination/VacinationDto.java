package br.com.clinicavt.models.vacination;

import br.com.clinicavt.models.pet.Pet;

import java.util.UUID;

public record VacinationDto(String vaccine, Pet petName) {
}
