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
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Table(name = "vacination")
@Entity(name = "vacination")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class VacinationEmbeddable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToMany(mappedBy = "vaccines")
    private List<Pet> pets;

    private List<String> vaccines;

    private Boolean active;

    public void setVaccines(String vaccines){
        this.vaccines.add(vaccines);
    }

    public VacinationEmbeddable(VacinationDto vacinationDto){
        this.pets = Collections.singletonList(vacinationDto.petName());
        this.vaccines.add(vacinationDto.vaccine());
        this.active = true;
    }

    public void delete(){
        this.active = false;
    }

    public void updateVacination (VacinationUpdate vacinationUpdate){
        if (this.pets != null){
            this.pets = Collections.singletonList(vacinationUpdate.petName());
        }
        if (vacinationUpdate.vaccine() != null){
            this.vaccines.add(vacinationUpdate.vaccine());
        }
    }

}
