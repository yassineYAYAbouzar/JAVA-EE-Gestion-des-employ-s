package gestion.employee.services;

import gestion.employee.Entities.Employee;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
	 Employee saveUser(Employee employee);
	 Boolean deleteUser(String uuid);
	 List<Employee> getUsers();
	 Employee updateElement(Employee employee);
	 Employee getEmployee(String uuId);
	 Employee findByEmailAndPassword(String email, String password);
	 int changePassword(String email, String password);
}
