package br.com.clinicavt.models.vacination;

import br.com.clinicavt.models.pet.Pet;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Table(name = "vacination")
@Entity(name = "vacination")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Vacination extends RepresentationModel<Vacination> implements Serializable {

    @Serial
    private static final Long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    private Pet petName;

    @NotBlank
    private String vaccine;

    private Boolean active;

    public Vacination(VacinationDto vacinationDto){
        this.id = UUID.randomUUID();
        this.petName = vacinationDto.petName();
        this.vaccine = vacinationDto.vaccine();
        this.active = true;
    }

    public void delete(){
        this.active = false;
    }

    public void updateVacination (VacinationUpdate vacinationUpdate){
        if (this.petName != null){
            this.petName = vacinationUpdate.petName();
        }
        if (this.vaccine != null){
            this.vaccine = vacinationUpdate.vaccine();
        }
    }

}
