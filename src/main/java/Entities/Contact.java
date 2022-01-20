package Entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer mobileNumber;
    private Integer fixNumber;

    public Contact(Integer mobileNumber, Integer fixNumber) {
        this.mobileNumber = mobileNumber;
        this.fixNumber = fixNumber;
    }
}
