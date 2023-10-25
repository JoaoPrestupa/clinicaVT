package br.com.clinicavt.models.internacao;

import br.com.clinicavt.models.cliente.Clients;
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
@Table(name = "internacao")
public class Internacao extends RepresentationModel<Internacao> implements Serializable {

    @Serial
    private static final Long serialVersionUUID = 1L;

    @Id
    private UUID id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @NotBlank
    private Pet animal;

    @NotBlank
    private Clients cliente;

    @NotBlank
    private Veterinario veterinario;

    @Temporal(TemporalType.DATE)
    private Date data;

    private Medicamento medicamento;

    @NotBlank
    private BigDecimal valor;
    private Boolean ativo;

    public Internacao(InternacaoRecordDto internacaoDto){
        this.animal = internacaoDto.animal();
        this.cliente = internacaoDto.cliente();
        this.veterinario = internacaoDto.veterinario();
        this.data = internacaoDto.data();
        this.medicamento = internacaoDto.medicamento();
        this.valor = internacaoDto.valor();
        this.ativo = internacaoDto.ativo();
    }

    public void updateInternacao(DadosAtualizacaoInternacao dados){
        if(dados.animal() != null){
            this.animal = dados.animal();
        }
        if (dados.cliente() != null){
            this.cliente = dados.cliente();
        }
        if (dados.veterinario() != null){
            this.veterinario = dados.veterinario();
        }
        if (dados.data() != null){
            this.data = dados.data();
        }
        if (dados.medicamento() != null){
            this.medicamento = dados.medicamento();
        }
        if (dados.valor() != null){
            this.valor = dados.valor();
        }
        if (dados.ativo() != null){
            this.ativo = dados.ativo();
        }
    }

}