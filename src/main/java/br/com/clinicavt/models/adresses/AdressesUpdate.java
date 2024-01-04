package br.com.clinicavt.models.adresses;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public record AdressesUpdate(
                             @Pattern(regexp = "\\d{8}")
                             String cep,
                             String bairro,
                             String rua,
                             String cidade,
                             @Pattern(regexp = "\\d{2}")
                             String uf,
                             String complemento,
                             String numero) {
}
