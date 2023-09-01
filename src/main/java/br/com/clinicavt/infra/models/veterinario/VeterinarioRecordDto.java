package br.com.clinicavt.infra.models.veterinario;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record VeterinarioRecordDto(@NotBlank String nome, @NotBlank String telefone, Date nascimento,
                                   @NotBlank String crmv, @NotBlank Especialidade especialidade) {
}
