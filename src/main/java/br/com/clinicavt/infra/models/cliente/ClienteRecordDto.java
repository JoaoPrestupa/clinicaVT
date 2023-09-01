package br.com.clinicavt.infra.models.cliente;

import br.com.clinicavt.infra.models.veterinario.EnderecoEmbeddable;

import java.math.BigDecimal;
import java.util.Date;

public record ClienteRecordDto(String nome, Date dataCadastro, EnderecoEmbeddable endereco, String email, String telefone,
                               Boolean ativo, Date nascimento, Integer codigo, BigDecimal cpf) {
}
