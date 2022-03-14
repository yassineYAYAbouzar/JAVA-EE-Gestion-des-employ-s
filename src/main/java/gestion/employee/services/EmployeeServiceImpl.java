package gestion.employee.services;

import com.fasterxml.uuid.Generators;
import gestion.employee.Dae.EmployeeDae;
import gestion.employee.Dae.EmployeeImp;
import gestion.employee.Entities.Employee;
import gestion.employee.repository.EmployeeRepository;
import gestion.employee.repository.EmployeeRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDae employeeDae;

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeDae employeeDae ,EmployeeRepository employeeRepository) {
		this.employeeDae = employeeDae;
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveUser(Employee employee) {
		employee.setUserId(String.valueOf(Generators.randomBasedGenerator().generate()));
		employee.setPassword("password");
		return employeeDae.insertElement(employee);
	}
	@Override
	public Boolean deleteUser(String uuId) {
		employeeDae.deleteElement(uuId);
		return true;
	}
	@Override
	public List<Employee> getUsers() {
		return employeeDae.selectAllElements();
	}

	@Override
	public Employee updateElement(Employee employee) {
		employee.setPassword("password");
		employee.setUserId(String.valueOf(Generators.randomBasedGenerator().generate()));
		return employeeDae.updateElement(employee);
	}

	@Override
	public Employee getEmployee(String uuId) {
		return employeeDae.getElementById(uuId);
	}

	@Override
	public Employee findByEmailAndPassword(String email, String password) {
		return employeeRepository.findByEmailAndPassword(email,password);
	}

	@Override
	public int changePassword(String email, String password) {
		return employeeRepository.changePassword(email,password);
	}
}





