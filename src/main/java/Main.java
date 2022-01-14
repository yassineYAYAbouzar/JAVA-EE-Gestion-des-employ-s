import Dae.AddressImp;
import Dae.EmployeeImp;
import Database.HibernateUtil;
import Entities.Address;
import Entities.Employee;
import Entities.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {


        EmployeeImp employeeImp = new EmployeeImp();
        Employee employee = new Employee();
        employee.setEmail("yassinebouzar@gmail.com");
        employee.setFirstName("dd");
        employee.setLastName("la");
        employee.setPassword("password");
        employee.setRole(Role.ADMIN);
        employee.getAddresses().add(new Address("dd","dd",employee));


        employeeImp.insertElement(employee);

    }
}
