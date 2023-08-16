package br.com.clinicavt.infra.models.cliente;

import br.com.clinicavt.infra.models.veterinario.EnderecoEmbeddable;

import java.util.Date;

public record DadosAtualizacaoCliente(String nome, Date dataCadastro, EnderecoEmbeddable endereco, String email,
                                      String telefone, Boolean ativo, Date nascimento) {
}
