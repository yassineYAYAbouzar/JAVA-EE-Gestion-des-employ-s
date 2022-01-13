package DataAccess.Entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "address_table")
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String city;
    private Integer zipCode;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
