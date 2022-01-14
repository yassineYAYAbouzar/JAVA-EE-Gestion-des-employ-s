package Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@SuperBuilder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "employee_table")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true ,length = 70)
    private String email;
    private String password;
    private Role role ;


    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.ALL)
    Set<Address> addresses = new HashSet<>();

}
