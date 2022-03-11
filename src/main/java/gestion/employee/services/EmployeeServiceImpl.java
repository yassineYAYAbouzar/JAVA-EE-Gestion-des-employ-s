package gestion.employee.services;

import com.fasterxml.uuid.Generators;
import gestion.employee.Dae.EmployeeImp;
import gestion.employee.Entities.Employee;
import gestion.employee.repository.EmployeeRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeImp employeeImp;

	@Autowired
	private EmployeeRepositoryImp employeeRepositoryImp;


	@Override
	public Employee saveUser(Employee employee) {
		employee.setUserId(String.valueOf(Generators.randomBasedGenerator().generate()));
		employee.setPassword("password");
		return employeeImp.insertElement(employee);
	}
	@Override
	public Boolean deleteUser(String uuId) {
		employeeImp.deleteElement(uuId);
		return true;
	}
	@Override
	public List<Employee> getUsers() {
		return employeeImp.selectAllElements();
	}

	@Override
	public Employee updateElement(Employee employee) {
		employee.setPassword("password");
		employee.setUserId(String.valueOf(Generators.randomBasedGenerator().generate()));
		return employeeImp.updateElement(employee);
	}

	@Override
	public Employee getEmployee(String uuId) {
		return employeeImp.getElementById(uuId);
	}

	@Override
	public Employee findByEmailAndPassword(String email, String password) {
		return employeeRepositoryImp.findByEmailAndPassword(email,password);
	}

	@Override
	public int changePassword(String email, String password) {
		return employeeRepositoryImp.changePassword(email,password);
	}
}





