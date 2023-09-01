package br.com.clinicavt.infra.models.financeiro;

import br.com.clinicavt.infra.models.cirurgia.Cirurgia;
import br.com.clinicavt.infra.models.colaborador.Colaborador;
import br.com.clinicavt.infra.models.consulta.Consulta;
import br.com.clinicavt.infra.models.equipamento.Equipamento;
import br.com.clinicavt.infra.models.internacao.Internacao;
import br.com.clinicavt.infra.models.vacinacao.Vacinacao;

public record FinanceiroRecordDto(Colaborador salarioColaborador, Internacao valorInternacao, Equipamento valorEquipamento,
                                  Cirurgia valorCirurgia, Consulta valorConsulta, Vacinacao valorVacinacao) {
}
