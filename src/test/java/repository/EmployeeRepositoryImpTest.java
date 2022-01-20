package repository;

import Entities.Contact;
import Entities.Employee;
import Entities.Role;
import com.fasterxml.uuid.Generators;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryImpTest {
    EmployeeRepositoryImp employeeRepositoryImp = new EmployeeRepositoryImp();
    @Test
    void findByEmail() {
        assertNotNull(employeeRepositoryImp.findByEmail("yassinebouzar123@gmail.com"));
    }

    @Test
    void findByEmailAndPassword() {
     assertNotNull(employeeRepositoryImp.findByEmailAndPassword("yassinebouzar123@gmail.com","newpassword"));
    }

    @Test
    void changePassword() {
       int employeeActual = 1;
       assertEquals(employeeActual,employeeRepositoryImp.changePassword("yassinebouzar123@gmail.com","newpassword"));
    }
}