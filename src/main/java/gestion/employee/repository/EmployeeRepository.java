package gestion.employee.repository;

import gestion.employee.Entities.Employee;

import java.util.List;

public interface EmployeeRepository{

    Employee findByEmail(String email);
    List<Employee> getAllEmployesWithAdresses();
    Employee findByEmailAndPassword(String email, String password);
    int changePassword(String email, String password) ;


}
