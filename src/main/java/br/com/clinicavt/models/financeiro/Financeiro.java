package br.com.clinicavt.models.financeiro;

import br.com.clinicavt.models.cirurgia.Cirurgia;
import br.com.clinicavt.models.colaborador.Colaborador;
import br.com.clinicavt.models.consulta.Consulta;
import br.com.clinicavt.models.equipamento.Equipamento;
import br.com.clinicavt.models.internacao.Internacao;
import br.com.clinicavt.models.vacinacao.Vacinacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "financeiro")
public class Financeiro extends RepresentationModel<Financeiro> implements Serializable {

    @Serial
    private static final Long serialVersionUUID = 1L;

    @Id
    private UUID id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    @NotBlank
    private Colaborador salarioColaborador;
    @NotBlank
    private Internacao valorInternacao;
    @NotBlank
    private Equipamento valorEquipamento;
    @NotBlank
    private Cirurgia valorCirurgia;
    @NotBlank
    private Consulta valorConsulta;
    @NotBlank
    private Vacinacao valorVacinacao;
    private Boolean ativo;



    public Financeiro(FinanceiroRecordDto financeiroDto){
        this.id = UUID.randomUUID();
        this.salarioColaborador = financeiroDto.salarioColaborador();
        this.valorInternacao = financeiroDto.valorInternacao();
        this.valorEquipamento = financeiroDto.valorEquipamento();
        this.valorCirurgia = financeiroDto.valorCirurgia();
        this.valorConsulta = financeiroDto.valorConsulta();
        this.valorVacinacao = financeiroDto.valorVacinacao();
        this.ativo = financeiroDto.ativo();
    }

    public void updateFinanceiro(DadosAtualizacaoFinanceiro dados){
        if (dados.salarioColaborador() != null){
            this.salarioColaborador = dados.salarioColaborador();
        }
        if (dados.valorInternacao() != null){
            this.valorInternacao = dados.valorInternacao();
        }
        if (dados.valorEquipamento() != null){
            this.valorEquipamento = dados.valorEquipamento();
        }
        if (dados.valorCirurgia() != null){
            this.valorCirurgia = dados.valorCirurgia();
        }
        if (dados.valorConsulta() != null){
            this.valorConsulta = dados.valorConsulta();
        }
        if (dados.valorVacinacao() != null){
            this.valorVacinacao = dados.valorVacinacao();
        }
        if (dados.ativo() != null){
            this.ativo = dados.ativo();
        }
    }

}
