package br.com.clinicavt.models.client;

import br.com.clinicavt.models.AdressesEmbeddable;
import br.com.clinicavt.models.pet.Pet;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record ClientDto(String nome,
                        Date dataCadastro,
                        AdressesEmbeddable endereco,
                        String email,
                        String telefone,
                        Boolean ativo,
                        Date nascimento,
                        String cpf) {
}
