package br.com.clinicavt.dtos;

import br.com.clinicavt.models.EnderecoEmbeddable;
import br.com.clinicavt.models.Especialidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record VeterinarioRecordDto(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String telefone,
@NotBlank String crmv, @NotBlank String salario, Especialidade especialidade, EnderecoEmbeddable endereco) {
}
