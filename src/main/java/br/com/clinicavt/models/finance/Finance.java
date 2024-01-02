package br.com.clinicavt.models.finance;

import br.com.clinicavt.models.employe.Employe;
import br.com.clinicavt.models.consult.Consult;
import br.com.clinicavt.models.veterinarian.Veterinanian;
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
public class Finance extends RepresentationModel<Finance> implements Serializable {

    @Serial
    private static final Long serialVersionUUID = 1L;

    @Id
    private UUID id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    @NotBlank
    private Employe salarioColaborador;
    @NotBlank
    private Consult valorConsulta;
    @NotBlank
    private Veterinanian valorVacinacao;
    private Boolean ativo;



    public Finance(FinanceDto financeiroDto){
        this.id = UUID.randomUUID();
        this.salarioColaborador = financeiroDto.salarioColaborador();
        this.valorConsulta = financeiroDto.valorConsulta();
        this.valorVacinacao = financeiroDto.valorVacinacao();
        this.ativo = financeiroDto.ativo();
    }

    public void updateFinance(FinanceUpdate dados){
        if (dados.salarioColaborador() != null){
            this.salarioColaborador = dados.salarioColaborador();
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
