package br.com.clinicavt.models.consulta;

import br.com.clinicavt.models.cliente.Client;
import br.com.clinicavt.models.pet.Pet;
import br.com.clinicavt.models.veterinario.Veterinario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "consulta")
public class Consulta extends RepresentationModel<Consulta> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;
    @Temporal(TemporalType.DATE)
    private Date data;
    @NotBlank
    private Client cliente;
    @NotBlank
    private Boolean web;
    @NotBlank
    private String descricao;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    private Boolean ativo;
    private BigDecimal valor;
    private Boolean cancelada;
    @NotBlank
    private Pet animal;
    private Veterinario veterinario;



    public Consulta(ConsultaRecordDto consultaDto) {
        this.data = consultaDto.data();
        this.cliente = consultaDto.cliente();
        this.web = consultaDto.web();
        this.descricao = consultaDto.descricao();
        this.ativo = consultaDto.ativo();
        this.valor = consultaDto.valor();
        this.cancelada = consultaDto.cancelada();
        this.animal = consultaDto.animal();
        this.veterinario = consultaDto.veterinario();
    }

    public void updateConsulta(DadosAtualizacaoConsulta dados){

        if (dados.data() != null){
            this.data = dados.data();
        }
        if (dados.cliente() !=null){
            this.cliente = dados.cliente();
        }
        if (dados.web() != null){
            this.web = dados.web();
        }
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if (dados.ativo() != null){
            this.ativo = dados.ativo();
        }
        if (dados.valor() != null){
            this.valor = dados.valor();
        }
        if (dados.cancelada() != null){
            this.cancelada = dados.cancelada();
        }
        if (dados.animal() != null){
            this.animal = dados.animal();
        }
        if (dados.veterinario() != null){
            this.veterinario = dados.veterinario();
        }

    }


}
