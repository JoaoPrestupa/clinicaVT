package br.com.clinicavt.models.cliente;

import br.com.clinicavt.models.veterinario.EnderecoEmbeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public record ClientsUpdate(
        UUID id,
        String nome,
        EnderecoEmbeddable endereco,
        String email,
        String telefone,
        Date nascimento,
        String cpf) {
}
