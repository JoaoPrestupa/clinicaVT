package br.com.clinicavt.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataAdressesDto(
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String bairro,
        @NotBlank
        String rua,
        @NotBlank
        String cidade,
        @NotBlank
        @Pattern(regexp = "\\d{2}")
        String uf,
        @NotBlank
        String complemento,
        @NotBlank
        String numero
) {
}
