package br.com.clinicavt.infra.models.pet;

import br.com.clinicavt.infra.models.cliente.Cliente;
import br.com.clinicavt.infra.models.consulta.Consulta;
import br.com.clinicavt.infra.models.vacinacao.Vacinacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "pets")
public class Pet extends RepresentationModel<Pet> implements Serializable {

    @Serial
    private static final Long serialVersionUID = 1L;

    @Id
    private UUID id;
    @NotBlank
    private String nome;
    @NotBlank
    private Cliente cliente;
    private Consulta dataUltimaConulta;
    private Boolean ativo;
    private String descricaoPet;
    @Enumerated(EnumType.STRING)
    private AnimaisEnum animal;
    private String raca;
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    private Integer codigo;
    private Vacinacao vacinacao;

    public Pet(PetsRecordDto petsDto){
        this.id = UUID.randomUUID();
        this.nome = petsDto.nome();
        this.cliente = petsDto.cliente();
        this.dataUltimaConulta = petsDto.dataUltimaConsulta();
        this.ativo = petsDto.ativo();
        this.descricaoPet = petsDto.descricaoPet();
        this.animal = petsDto.animal();
        this.raca = petsDto.raca();
        this.nascimento = petsDto.nascimento();
        this.codigo = petsDto.codigo();
        this.vacinacao = petsDto.vacinacao();
    }

    public void updateConsulta(DadosAtualizacaoPet dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.cliente() != null){
            this.cliente = dados.cliente();
        }
        if (dados.dataUltimaConsulta() != null){
            this.dataUltimaConulta = dados.dataUltimaConsulta();
        }
        if (dados.ativo() != null){
            this.ativo = dados.ativo();
        }
        if (dados.descricaoPet() != null){
            this.descricaoPet = dados.descricaoPet();
        }
        if (dados.animal() != null){
            this.animal = dados.animal();
        }
        if (dados.raca() != null){
            this.raca = dados.raca();
        }
        if (dados.nascimento() != null){
            this.nascimento = dados.nascimento();
        }
        if (dados.codigo() != null){
            this.codigo = dados.codigo();
        }
        if (this.vacinacao != null){
            this.vacinacao = dados.vacinacao();
        }
    }

}
