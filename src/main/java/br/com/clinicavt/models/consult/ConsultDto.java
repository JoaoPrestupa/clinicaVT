package br.com.clinicavt.models.consult;

import br.com.clinicavt.models.client.Client;
import br.com.clinicavt.models.pet.Pet;
import br.com.clinicavt.models.veterinarian.Veterinanian;

import java.math.BigDecimal;
import java.util.Date;

public record ConsultDto(Date data, String description, Integer code, BigDecimal value, Client client, Pet pet, Veterinanian veterinanian) {
}
