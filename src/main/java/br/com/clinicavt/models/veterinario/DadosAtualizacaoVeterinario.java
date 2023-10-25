package br.com.clinicavt.models.veterinario;


import java.util.Date;

public record DadosAtualizacaoVeterinario(String nome, Date nascimento,
                                          String crmv,Especialidade especialidade, Boolean ativo) {
}
