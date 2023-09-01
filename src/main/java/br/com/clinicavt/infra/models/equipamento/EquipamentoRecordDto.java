package br.com.clinicavt.infra.models.equipamento;

import java.math.BigDecimal;

public record EquipamentoRecordDto(String descricao, Boolean patrimonio, String codPatrimonio,
                                   CondicaoEquipamento condicao, BigDecimal valor) {
}
