package repository;

import Entities.Employee;
import Entities.Role;

import java.util.List;

public interface GenericRepo<T , Long> {

    Employee findByEmail(String email);
    List<T> getAllEmployesWithAdresses();
    Employee findByEmailAndPassword(String email, String password);
    int changeRole(String email, Role role);
    int changePassword(String email, String password) ;


}
