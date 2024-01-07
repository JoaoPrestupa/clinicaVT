package br.com.clinicavt.models.pet;

import br.com.clinicavt.models.client.Client;
import br.com.clinicavt.models.consult.Consult;
import br.com.clinicavt.models.veterinarian.Veterinanian;

import java.util.Date;
import java.util.UUID;

public record PetUpdate(
        UUID idPet,
        String nome,
        Client client,
        Boolean ativo,
        String descricaoPet,
        PetEnum animal,
        String raca,
        Date nascimento ,
        String welfare_animal) {
}
