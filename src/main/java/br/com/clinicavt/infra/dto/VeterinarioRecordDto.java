package br.com.clinicavt.infra.dto;

import br.com.clinicavt.infra.models.veterinario.EnderecoEmbeddable;
import br.com.clinicavt.infra.models.veterinario.Especialidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record VeterinarioRecordDto(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String telefone,
                                   @NotBlank String crmv, @NotBlank String salario, Especialidade especialidade, EnderecoEmbeddable endereco) {
}
