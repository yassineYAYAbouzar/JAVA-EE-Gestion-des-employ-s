package DataAccess.Dae;

import DataAccess.Entities.Employee;
import DataAccess.Role;
import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeImpTest extends TestCase {

    private EmployeeImp employeeImp = new EmployeeImp();
    private Employee employee;
    public void setUp() throws Exception {
        employee = employee.builder()
                .email("yassinebouzar@gmail.com")
                .password("password")
                .lastName("yassine101")
                .firstName("password")
                .role(Role.ADMIN)
                .build();
    }

    public void testInsertEmployee() {
        Employee employeeActual =employeeImp.insertEmployee(employee);
        assertEquals(employeeActual, employee);
    }

    public void testGetEmployeeById() {
        Employee employeeExpected =employeeImp.insertEmployee(employee);
        assertEquals(employeeExpected, employeeImp.getEmployeeById(employeeExpected.getId()));
    }

    public void testSelectAllEmployee() {
        assertNotNull(employeeImp.selectAllEmployee());
    }

    public void testDeleteEmployee() {
        Boolean expected  = employeeImp.deleteEmployee(66L);
        assertTrue(expected);
    }

    public void testUpdateEmployee() {
        Employee employeeActual = employeeImp.updateEmployee(employee);
        assertEquals(employeeActual, employee);
    }
}