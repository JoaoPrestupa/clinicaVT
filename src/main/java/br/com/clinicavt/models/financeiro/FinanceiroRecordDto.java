package br.com.clinicavt.models.financeiro;

import br.com.clinicavt.models.cirurgia.Cirurgia;
import br.com.clinicavt.models.colaborador.Colaborador;
import br.com.clinicavt.models.consulta.Consulta;
import br.com.clinicavt.models.equipamento.Equipamento;
import br.com.clinicavt.models.internacao.Internacao;
import br.com.clinicavt.models.vacinacao.Vacinacao;

public record FinanceiroRecordDto(Colaborador salarioColaborador, Internacao valorInternacao, Equipamento valorEquipamento,
                                  Cirurgia valorCirurgia, Consulta valorConsulta, Vacinacao valorVacinacao, Boolean ativo) {
}
