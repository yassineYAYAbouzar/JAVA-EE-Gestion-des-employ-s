package DataAccess.Entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Address {

    @Id
    @GeneratedValue
    @Column(name = "employee_adress")
    private Long id;
    private String street;
    private String city;
    private String pays;

    public Address(String street, String city, String pays) {
        this.street = street;
        this.city = city;
        this.pays = pays;
    }
}
