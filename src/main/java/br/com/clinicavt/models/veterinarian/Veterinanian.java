package br.com.clinicavt.models.veterinarian;

import br.com.clinicavt.models.AdressesEmbeddable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "veterinarian")
@Table(name = "Veterinarian")
public class Veterinanian extends RepresentationModel<Veterinanian> implements Serializable {

    @Serial
    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Size(min = 5, message = "Um nome deve conter no mínimo 5 caracteres.")
    private String name;

    @Embedded
    private AdressesEmbeddable adress;

    @Email(message = "Um veterinário deve conter um endereço de email válido.")
    private String email;

    @NotNull(message = "Um veterinário deve ter um crmv registrado e válido.")
    private String crmv;

    @Temporal(TemporalType.DATE)
    private Date data;

    private BigDecimal salary;

    private Boolean ativo;

    public Veterinanian(VeterinarianDto veterinarianDto){
        this.data = veterinarianDto.data();
        this.adress = veterinarianDto.adress();
        this.email = veterinarianDto.email();
        this.crmv = veterinarianDto.crmv();
        this.salary = veterinarianDto.salary();
        this.ativo = true;
    }

    public void updateVeterinarian(VeterinarianUpdate data){
        if (data.name() != null){
            this.name = data.name();
        }
        if (data.adress() != null){
            this.adress = data.adress();
        }
        if (data.email() != null){
            this.email = data.email();
        }
        if (data.crmv() != null){
            this.crmv = data.crmv();
        }
        if (data.salary() != null){
            this.salary = data.salary();
        }
    }

}
