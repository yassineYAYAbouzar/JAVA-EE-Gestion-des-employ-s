package repository;

import Entities.Employee;
import Entities.Role;

public interface GenericRepo<T , Long> {

    Employee findByEmail(String email);
    Employee findByEmailAndPassword(String email, String password);
    int changeRole(String email, Role role);
    int changePassword(String email, String password) ;


}
