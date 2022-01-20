package repository;

import Entities.Employee;
import Entities.Role;

import java.util.List;

public interface GenericRepo<T , Long> {

    Employee findByEmail(String email);
    Employee findByEmailAndPassword(String email, String password);
    int changePassword(String email, String password) ;


}
