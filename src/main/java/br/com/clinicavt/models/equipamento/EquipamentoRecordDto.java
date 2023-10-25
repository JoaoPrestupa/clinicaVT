package br.com.clinicavt.models.equipamento;

import java.math.BigDecimal;

public record EquipamentoRecordDto(String descricao, Boolean patrimonio, String codPatrimonio,
                                   CondicaoEquipamento condicao, BigDecimal valor, Boolean ativo) {
}
