package br.com.clinicavt.infra.models.medicamento;

import java.math.BigDecimal;

public record DadosAtualizacaoMedicamento(Integer quantidade, String nome, String marca, String descricao,
                                            String validade, Integer codigo, BigDecimal valor)
{
}
