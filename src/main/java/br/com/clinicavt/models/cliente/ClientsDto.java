package br.com.clinicavt.models.cliente;

import br.com.clinicavt.models.veterinario.EnderecoEmbeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Date;

public record ClientsDto(String nome,
                         Date dataCadastro,
                         EnderecoEmbeddable endereco,
                         String email,
                         String telefone,
                         Boolean ativo,
                         Date nascimento,
                         String cpf) {
}
