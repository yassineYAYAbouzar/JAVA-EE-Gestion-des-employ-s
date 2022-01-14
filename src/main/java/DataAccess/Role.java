package DataAccess;

import lombok.Getter;
import lombok.Setter;

@Getter


public enum Role {
    EMPLOYEE("employee"),
    ADMIN("admin");
    private final String nom;
    Role(String nom) {
        this.nom = nom;
    }

}
