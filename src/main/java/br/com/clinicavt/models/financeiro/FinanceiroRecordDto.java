package br.com.clinicavt.models.financeiro;

import br.com.clinicavt.models.cirurgia.Cirurgia;
import br.com.clinicavt.models.colaborador.Employe;
import br.com.clinicavt.models.consulta.Consulta;
import br.com.clinicavt.models.equipamento.Equipamento;
import br.com.clinicavt.models.internacao.Internacao;
import br.com.clinicavt.models.veterinarian.Veterinanian;

public record FinanceiroRecordDto(Employe salarioColaborador, Internacao valorInternacao, Equipamento valorEquipamento,
                                  Cirurgia valorCirurgia, Consulta valorConsulta, Veterinanian valorVacinacao, Boolean ativo) {
}
