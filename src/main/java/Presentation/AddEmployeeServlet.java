package Presentation;

import Dae.EmployeeImp;
import Entities.Address;
import Entities.Contact;
import Entities.Employee;
import Entities.Role;
import Presentation.config.ThymleafConfig;
import com.fasterxml.uuid.Generators;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "Presentation.AddEmployeeServlet" , urlPatterns ="/employee/add")
public class AddEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateEngine engine = ThymleafConfig.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request,response,request.getServletContext());

        List<Role> roleList = new ArrayList<>();
        roleList.add(Role.EMPLOYEE);
        roleList.add(Role.ADMIN);

        context.setVariable("roleList",roleList);

        engine.process("addEmployee.html" ,context ,response.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        TemplateEngine engine = ThymleafConfig.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String street1 = request.getParameter("street1");
        String city1 = request.getParameter("city1");



        Integer fix = Integer.valueOf(request.getParameter("fix"));
        Integer mobile = Integer.valueOf(request.getParameter("mobile"));






        EmployeeImp employeeImp = new EmployeeImp();
        Employee employee=new Employee() ;
        Contact contact = new Contact();
        contact.setMobileNumber(fix);
        contact.setFixNumber(mobile);
        employee.setFirstName(firstName);
        employee.setEmail(email);
        employee.setLastName(lastName);
        employee.setRole(Role.valueOf(request.getParameter("role")));
        employee.setContact(contact);
        employee.getAddresses().add(new Address(street,city,employee));
        employee.getAddresses().add(new Address(street1,city1,employee));
        UUID uuid = Generators.randomBasedGenerator().generate();
        employee.setUserId(String.valueOf(uuid));
        try {
            employee = employeeImp.insertElement(employee);
            HttpSession session = request.getSession(true);
            session.setAttribute("employee", employee);
            if (employee.getId() == null){
                context.setVariable("error", " failed! Error pleas enter a valid fields");
                engine.process("addEmployee.html", context, response.getWriter());
            }else{
                response.sendRedirect(request.getContextPath() + "/employee");
            }

        }catch (Exception e){
            if(employee.getId() == null){
                context.setVariable("error", "Login failed! Error in email or password");
                engine.process("addEmployee.html", context, response.getWriter());
            }

        }
    }
}
