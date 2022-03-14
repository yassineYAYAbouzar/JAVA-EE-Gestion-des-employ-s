package gestion.employee.Dae;

import gestion.employee.Entities.Employee;

import java.io.Serializable;
import java.util.List;

public interface EmployeeDae extends Serializable {
    Employee insertElement(Employee employee);
    Employee getElementById(String userId);
    List<Employee> selectAllElements();
    boolean deleteElement(String userId);
    Employee updateElement(Employee employee) ;
}

