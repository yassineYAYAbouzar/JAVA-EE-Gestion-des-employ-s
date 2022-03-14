package Presentation.services;

import gestion.employee.Dae.EmployeeDae;
import gestion.employee.Entities.Contact;
import gestion.employee.Entities.Employee;
import gestion.employee.Entities.Role;
import gestion.employee.services.EmployeeService;
import gestion.employee.services.EmployeeServiceImpl;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class EmployeeServiceTest  {


}
