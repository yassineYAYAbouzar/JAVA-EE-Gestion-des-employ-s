package Presentation.services;

import Dae.EmployeeImp;
import Database.HibernateUtil;
import Entities.Address;
import Entities.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeService {
    EmployeeImp employeeImp = new EmployeeImp();
    public Employee insertElement(Employee employee, Address address) {
        address.setEmployee(employee);
        employee.getAddresses().add(address);
        employeeImp.insertElement(employee);
        return new Employee();
    }
}
