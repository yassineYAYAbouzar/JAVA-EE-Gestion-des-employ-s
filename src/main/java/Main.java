import DataAccess.Dae.EmployeeImp;
import DataAccess.Entities.Employee;
import DataAccess.Role;


public class Main {
    public static void main(String[] args) {

        EmployeeImp employeeImp = new EmployeeImp();
        Employee employee = new Employee();

        employee.setEmail("emjkkjail");
        employee.setFirstName("first Name");
        employee.setRole(Role.EMPLOYEE);
        employee.setPassword("password");
        employee.setLastName("lasstname");
        employeeImp.insertEmployee(employee);
    }
}
