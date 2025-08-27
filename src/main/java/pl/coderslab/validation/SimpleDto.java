package pl.coderslab.validation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;

@Getter
@Setter
public class SimpleDto {
    @Min(1)
    private int id;
    @Size(min = 5, max = 100)
    private String name;
    @PESEL
    private String pesel;
}
