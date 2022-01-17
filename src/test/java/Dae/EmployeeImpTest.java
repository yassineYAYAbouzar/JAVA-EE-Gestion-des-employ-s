package Dae;

import Entities.Address;
import Entities.Contact;
import Entities.Employee;
import Entities.Role;
import junit.framework.TestCase;
import org.checkerframework.checker.units.qual.A;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeImpTest extends TestCase {

    private EmployeeImp employeeImp = new EmployeeImp();
    private Employee employee;
    private Employee employee1;
    private Contact contact;
    private Address address;
    public void setUp() throws Exception {
        contact = contact.builder()
                .mobileNumber(555)
                .fixNumber(88)
                .build();
        employee = employee.builder()
                .email("yassinebouzar1@gmail.com")
                .password("password")
                .lastName("yassine101")
                .firstName("password")
                .contact(contact)
                .role(Role.EMPLOYEE)
                .build();
        address = address.builder()
                .city("myoussoufia")
                .city("massira")
                .employee(employee)
                .build();
        employee1 = employee1.builder()
                .email("yassinebouzar@gmail.com")
                .password("password")
                .lastName("yassine101")
                .firstName("password")
                .contact(contact)
                .addresses(Collections.singleton(address))
                .role(Role.ADMIN)
                .build();

    }

    public void testInsertEmployee() {
        Employee employeeActual =employeeImp.insertElement(employee);
        System.out.println(employeeActual.getAddresses());
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