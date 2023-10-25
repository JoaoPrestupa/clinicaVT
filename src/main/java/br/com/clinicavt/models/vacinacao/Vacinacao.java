package br.com.clinicavt.models.vacinacao;

import br.com.clinicavt.models.medicamento.Medicamento;
import br.com.clinicavt.models.pet.Pet;
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
@Table(name = "vacinacao")
public class Vacinacao extends RepresentationModel<Vacinacao> implements Serializable {

    @Serial
    private static final long serialVersionUUID = 1L;

    @Id
    private UUID id;
    @NotBlank
    private Pet animal;
    @NotBlank
    private Medicamento medicamento;
    @Temporal(TemporalType.DATE)
    private Date data;
    @NotBlank
    private BigDecimal valor;
    private Boolean ativo;

    public Vacinacao(VacinacaoRecordDto vacinacaoDto){
        this.id = UUID.randomUUID();
        this.animal = vacinacaoDto.animal();
        this.medicamento = vacinacaoDto.medicamento();
        this.data = vacinacaoDto.data();
        this.valor = vacinacaoDto.valor();
        this.ativo = vacinacaoDto.ativo();
    }

    public void updateVacinacao(VacinacaoRecordDto dados){
        if (dados.animal() != null){
            this.animal = dados.animal();
        }
        if (dados.medicamento() != null){
            this.medicamento = dados.medicamento();
        }
        if (dados.data() != null){
            this.data = dados.data();
        }
        if (dados.valor() != null){
            this.valor = dados.valor();
        }
        if (dados.ativo() != null){
            this.ativo = dados.ativo();
        }
    }


}
