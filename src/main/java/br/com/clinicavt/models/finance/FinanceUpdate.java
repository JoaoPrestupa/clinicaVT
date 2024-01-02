package br.com.clinicavt.models.finance;

import br.com.clinicavt.models.employe.Employe;
import br.com.clinicavt.models.consult.Consult;
import br.com.clinicavt.models.veterinarian.Veterinanian;

public record FinanceUpdate(Employe salarioColaborador, Veterinanian valorVacinacao,
                            Consult valorConsulta, Boolean ativo) {
}
