package DataAccess.Entities;

import DataAccess.Role;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
    @Column(name = "employee_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true ,length = 200)
    private String email;
    private String password;
    private Role role ;

   // @OneToMany
   // private Collection<Address> address = new ArrayList<>();


}
