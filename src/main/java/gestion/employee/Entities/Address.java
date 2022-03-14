package gestion.employee.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 3 , max = 14 ,message = "street must be between 3 and 14 character")
    private String street;
    @Size(min = 3 , max = 14 ,message = "city must be between 3 and 14 character")
    private String city;

}
