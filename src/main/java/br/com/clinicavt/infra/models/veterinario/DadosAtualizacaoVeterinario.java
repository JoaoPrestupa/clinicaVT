package br.com.clinicavt.infra.models.veterinario;


import java.util.Date;

public record DadosAtualizacaoVeterinario(String nome, Date nascimento,
                                          String crmv,Especialidade especialidade) {
}
