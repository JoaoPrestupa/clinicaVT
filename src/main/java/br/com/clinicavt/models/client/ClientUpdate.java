package br.com.clinicavt.models.client;

import br.com.clinicavt.models.adresses.AdressesEmbeddable;

import java.util.Date;
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
