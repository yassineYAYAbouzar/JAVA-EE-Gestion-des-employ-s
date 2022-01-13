package DataAccess.Entities;

import DataAccess.Role;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.*;

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
    @Column(name = "employee_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true ,length = 200)
    @Email
    private String email;
    private String password;
    private Role role ;

    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.ALL)

    private List<Address> addresses;

   // @OneToMany
   // private Collection<Address> address = new ArrayList<>();


}
