package br.com.clinicavt.models.cliente;

import br.com.clinicavt.models.veterinario.EnderecoEmbeddable;

import java.util.Date;
import java.util.UUID;

public record ClientUpdate(
        UUID id,
        String nome,
        EnderecoEmbeddable endereco,
        String email,
        String telefone,
        Date nascimento,
        String cpf) {
}
