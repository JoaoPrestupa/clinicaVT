package br.com.clinicavt.models.medicamento;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "medicamento")
public class Medicamento extends RepresentationModel<Medicamento> implements Serializable {

    @Serial
    private static final Long serialVersionUUID = 1L;

    @Id
    private UUID id;
    private Integer quantidade;
    @NotBlank
    private String nome;
    private String marca;
    private String descricao;
    private String validade;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    @NotBlank
    private BigDecimal valor;
    private Boolean ativo;

    public Medicamento(MedicamentoRecordDto medicamentoDto){
        this.id = UUID.randomUUID();
        this.quantidade = medicamentoDto.quantidade();
        this.nome = medicamentoDto.nome();
        this.marca = medicamentoDto.marca();
        this.descricao = medicamentoDto.descricao();
        this.validade = medicamentoDto.validade();
        this.codigo = medicamentoDto.codigo();
        this.valor = medicamentoDto.valor();
        this.ativo = medicamentoDto.ativo();
    }

    public void updateMedicamento(DadosAtualizacaoMedicamento dados){

        if (dados.quantidade() != null){
            this.quantidade = dados.quantidade();
        }
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.marca() != null){
            this.marca = dados.marca();
        }
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if (dados.validade() != null){
            this.validade = dados.validade();
        }
        if (dados.codigo() != null){
            this.codigo = dados.codigo();
        }
        if (dados.valor() != null){
            this.valor = dados.valor();
        }
        if (dados.ativo() != null){
            this.ativo = dados.ativo();
        }

    }

}