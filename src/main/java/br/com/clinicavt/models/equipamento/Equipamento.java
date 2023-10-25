package br.com.clinicavt.models.equipamento;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "equipamento")
public class Equipamento extends RepresentationModel<Equipamento> implements Serializable {

    private static final Long serialVersionUUID = 1L;

    @Id
    private UUID id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    @NotBlank
    private String descricao;
    private Boolean patrimonio;
    private String codPatrimonio;
    @Enumerated(EnumType.STRING)
    private CondicaoEquipamento condicao;
    @NotBlank
    private BigDecimal valor;

    private Boolean ativo;

    public Equipamento(EquipamentoRecordDto equipamentoDto){
        this.id = UUID.randomUUID();
        this.descricao = equipamentoDto.descricao();
        this.patrimonio = equipamentoDto.patrimonio();
        this.condicao = equipamentoDto.condicao();
        this.codPatrimonio = equipamentoDto.codPatrimonio();
        this.ativo = equipamentoDto.ativo();
    }

    public void updateEquipamento(DadosAtualizacaoEquipamento dados){
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if (dados.patrimonio() != null){
            this.patrimonio = dados.patrimonio();
        }
        if (dados.codPatrimonio() != null){
            this.codPatrimonio = dados.codPatrimonio();
        }
        if (dados.condicao() != null){
            this.condicao = dados.condicao();
        }
        if (dados.valor() != null){
            this.valor = dados.valor();
        }
        if (dados.ativo() != null){
            this.ativo = dados.ativo();
        }

    }

}
