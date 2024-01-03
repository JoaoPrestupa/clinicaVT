package br.com.clinicavt.models.client;

import br.com.clinicavt.models.AdressesEmbeddable;
import br.com.clinicavt.models.pet.Pet;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record ClientUpdate(

        UUID id,
        String nome,
        AdressesEmbeddable endereco,
        String email,
        String telefone,
        Date nascimento,
        String cpf) {
}
