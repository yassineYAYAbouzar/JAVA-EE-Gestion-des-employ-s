package gestion.employee.repository;

import gestion.employee.Entities.Employee;
import gestion.employee.Entities.Role;

import java.util.List;

public interface GenericRepo<T , Long> {

    Employee findByEmail(String email);
    List<T> getAllEmployesWithAdresses();
    Employee findByEmailAndPassword(String email, String password);
    int changePassword(String email, String password) ;


}
