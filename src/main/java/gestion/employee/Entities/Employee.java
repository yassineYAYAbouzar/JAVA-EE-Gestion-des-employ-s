package gestion.employee.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Setter
@SuperBuilder
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
@Table(name = "employee_table")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    @Size(min = 2, max = 18, message = "First Name must be between 2 and 18")
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true ,length = 70)
    private String email;
    private String password;

    private Role role ;

    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id" )
    @Valid
    private Contact contact;
    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    Set<Address> addresses = new HashSet<>();

}
