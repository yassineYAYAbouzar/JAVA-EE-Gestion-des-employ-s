package gestion.employee.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
    @NonNull
    @Size(min = 2, max = 18 , message = "firstName size must be between 2 and 18")
    @Column(name = "first_name")
    private String firstName;
    @NonNull
    @Size(min = 2, max = 18 , message = "lastName size must be between 2 and 18")
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true ,length = 70)
    @NonNull
    @Email
    private String email;
    @NonNull
    @Size(min = 4, max = 18 )
    private String password;
    private Role role ;

    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id" )
    @Valid
    private Contact contact;
    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id" )
    @Valid
    private Address address ;

    public Employee(String userId, @NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password, Role role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
