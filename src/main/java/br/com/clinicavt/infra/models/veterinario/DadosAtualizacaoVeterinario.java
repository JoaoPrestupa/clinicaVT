package br.com.clinicavt.infra.models.veterinario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoVeterinario(String nome, @Email String email, String telefone,
                                          String crmv, String salario, Especialidade especialidade, EnderecoEmbeddable endereco) {
}
