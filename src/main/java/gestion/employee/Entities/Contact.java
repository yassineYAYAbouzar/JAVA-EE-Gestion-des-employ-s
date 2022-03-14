package gestion.employee.Entities;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
@Entity
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    private Integer mobileNumber;
    private Integer fixNumber;

    public Contact(Integer mobileNumber, Integer fixNumber) {
        this.mobileNumber = mobileNumber;
        this.fixNumber = fixNumber;
    }
}
