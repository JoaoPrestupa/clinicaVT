package br.com.clinicavt.models.cirurgia;

import br.com.clinicavt.models.cliente.Client;
import br.com.clinicavt.models.medicamento.Medicamento;
import br.com.clinicavt.models.pet.Pet;
import br.com.clinicavt.models.veterinario.Veterinario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "cirurgia")
public class Cirurgia extends RepresentationModel<Cirurgia> implements Serializable {

    @Serial
    private static final Long serialVersionUUID = 1L;

    @Id
    private UUID id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    @NotBlank
    private Pet animal;
    @NotBlank
    private Client cliente;
    @NotBlank
    private Veterinario veterinario;
    private Medicamento medicamento;
    private String descricao;
    @Temporal(TemporalType.DATE)
    private Date data;
    private Boolean ativo;
    private Boolean sucesso;
    @NotBlank
    private BigDecimal valor;

    public Cirurgia(CirurgiaRecordDto cirurgiaDto){
        this.id = UUID.randomUUID();
        this.codigo = cirurgiaDto.codigo();
        this.animal = cirurgiaDto.animal();
        this.cliente = cirurgiaDto.cliente();
        this.veterinario = cirurgiaDto.veterinario();
        this.medicamento = cirurgiaDto.medicamento();
        this.descricao = cirurgiaDto.descricao();
        this.data = cirurgiaDto.data();
        this.ativo = cirurgiaDto.ativo();
        this.sucesso = cirurgiaDto.sucesso();
        this.valor = cirurgiaDto.valor();
    }

    public void updateCirurgia(DadosAtualizacaoCirurgia dados){

        if (dados.codigo() != null){
            this.codigo = dados.codigo();
        }
        if (dados.animal() != null){
            this.animal = dados.animal();
        }
        if (dados.cliente() != null){
            this.cliente = dados.cliente();
        }
        if (dados.veterinario() != null){
            this.veterinario = dados.veterinario();
        }
        if (dados.medicamento() != null){
            this.medicamento = dados.medicamento();
        }


    }

}
