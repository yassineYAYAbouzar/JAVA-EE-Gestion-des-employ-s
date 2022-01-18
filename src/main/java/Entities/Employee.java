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
    private Contact contact;
    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    Set<Address> addresses = new HashSet<>();

}
