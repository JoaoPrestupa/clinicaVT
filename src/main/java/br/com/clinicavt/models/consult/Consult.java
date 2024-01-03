package br.com.clinicavt.models.consult;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Consult")
@Table(name = "consult")
public class Consult extends RepresentationModel<Consult> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Temporal(TemporalType.DATE)
    private Date date;

    private String description;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer code;

    private BigDecimal value;

    private Boolean cancel = false;

    private Boolean ativo;

    private String client;

    private String pet;

    private String veterinanian;

    public void cancelConsult(){
        this.cancel = true;
    }

    public Consult(ConsultDto consultaDto) {
        this.date = consultaDto.data();
        this.description = consultaDto.description();
        this.code = consultaDto.code();
        this.value = consultaDto.value();
        this.client = consultaDto.client().getNome();
        this.pet = consultaDto.pet().getNome();
        this.veterinanian = consultaDto.veterinanian().getName();
        this.ativo = true;
    }

    public void updateConsulta(ConsultUpdate dados){
        if (dados.date() != null){
            this.date = dados.date();
        }
        if (dados.description() != null){
            this.description = dados.description();
        }
        if (dados.code() != null){
            this.code = dados.code();
        }
        if (dados.value() != null){
            this.value = dados.value();
        }
        if (dados.client().getNome() != null){
            this.client = dados.client().getNome();
        }
        if (dados.pet().getNome() != null){
            this.pet = dados.pet().getNome();
        }
        if (dados.veterinanian().getName() != null){
            this.veterinanian = dados.veterinanian().getName();
        }
    }


}
