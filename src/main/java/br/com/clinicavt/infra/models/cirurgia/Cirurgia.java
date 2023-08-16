package br.com.clinicavt.infra.models.cirurgia;

import br.com.clinicavt.infra.models.cliente.Cliente;
import br.com.clinicavt.infra.models.medicamento.Medicamento;
import br.com.clinicavt.infra.models.pets.Pet;
import br.com.clinicavt.infra.models.veterinario.Veterinario;
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
    private Cliente cliente;
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

}
