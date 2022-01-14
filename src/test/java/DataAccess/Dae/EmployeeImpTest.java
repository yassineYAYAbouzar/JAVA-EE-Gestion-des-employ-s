package DataAccess.Dae;

import DataAccess.Entities.Employee;
import DataAccess.Role;
import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeImpTest extends TestCase {

    private EmployeeImp employeeImp = new EmployeeImp();
    private Employee employee;
    public void setUp() throws Exception {
        employee = employee.builder()
                .email("yassine12@gmail.com")
                .password("password")
                .lastName("yassine101")
                .firstName("password")
                .role(Role.EMPLOYEE)
                .build();
    }

    public void testInsertEmployee() {
        Employee employeeActual =employeeImp.insertElement(employee);

        assertEquals(employeeActual, employee);
    }

    public void testGetEmployeeById() {
        Employee employeeExpected =employeeImp.insertElement(employee);
        assertEquals(employeeExpected, employeeImp.getElementById(employeeExpected.getId()));
    }

    public void testSelectAllEmployee() {
        assertNotNull(employeeImp.selectAllElements());
    }

    public void testDeleteEmployee() {
        Boolean expected  = employeeImp.deleteElement(3L);
        assertTrue(expected);
    }

    public void testUpdateEmployee() {
        Employee employeeActual = employeeImp.updateElement(employee);
        assertEquals(employeeActual, employee);
    }
}