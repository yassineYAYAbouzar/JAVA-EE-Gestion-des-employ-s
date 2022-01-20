package Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Address(String street, String city, Employee employee) {
        this.street = street;
        this.city = city;
        this.employee = employee;
    }
}
