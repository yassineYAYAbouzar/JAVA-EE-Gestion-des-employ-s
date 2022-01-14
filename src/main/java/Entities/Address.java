package Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue
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
