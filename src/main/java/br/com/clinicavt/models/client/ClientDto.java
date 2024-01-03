package br.com.clinicavt.models.client;

import br.com.clinicavt.models.adresses.AdressesEmbeddable;

import java.util.Date;

public record ClientDto(String nome,
                        Date dataCadastro,
                        AdressesEmbeddable endereco,
                        String email,
                        String telefone,
                        Boolean ativo,
                        Date nascimento,
                        String cpf) {
}
