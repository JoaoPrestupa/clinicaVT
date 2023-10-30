package br.com.clinicavt.models.cliente;

import br.com.clinicavt.models.veterinario.EnderecoEmbeddable;

import java.util.Date;

public record ClientDto(String nome,
                        Date dataCadastro,
                        EnderecoEmbeddable endereco,
                        String email,
                        String telefone,
                        Boolean ativo,
                        Date nascimento,
                        String cpf) {
}
