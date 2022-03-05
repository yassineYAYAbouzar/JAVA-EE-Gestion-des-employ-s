/*package gestion.employee.Presentation;

import gestion.employee.Entities.Address;
import gestion.employee.Entities.Contact;
import gestion.employee.Dae.EmployeeImp;
import gestion.employee.Entities.Employee;
import gestion.employee.Presentation.config.ThymleafConfig;
import gestion.employee.Entities.Role;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "Presentation.UpdateEmployeeServlet" , urlPatterns =  "/employee/update")
public class UpdateEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      TemplateEngine engine = ThymleafConfig.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request,response,request.getServletContext());

        EmployeeImp employeeImp = new EmployeeImp();
        Employee employee = null;
        try {
             employee=  employeeImp.getElementById(request.getParameter("employeId"));
            List<Role> roleList = new ArrayList<>();
            roleList.add(Role.EMPLOYEE);
            roleList.add(Role.ADMIN);

            context.setVariable("roleList",roleList);
            context.setVariable("employee", employee);
            System.out.println(employee);
            engine.process("updateEmployee.html" ,context ,response.getWriter());

        }catch (Exception e){
            if(employee.getId() == null){
                context.setVariable("error", " No Employee Yet");
                request.getRequestDispatcher("/employee").forward(request, response);
            }

        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateEngine engine = ThymleafConfig.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request,response,request.getServletContext());
        String firstName = request.getParameter("firstName");
        Integer id = Integer.valueOf(request.getParameter("id"));
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        String street = request.getParameter("street");
        String city = request.getParameter("city");

        Integer fix = Integer.valueOf(request.getParameter("fix"));
        Integer mobile = Integer.valueOf(request.getParameter("mobile"));

        Employee employee = new Employee();
        Contact contact = new Contact();
        contact.setMobileNumber(fix);
        contact.setFixNumber(mobile);
        employee.setFirstName(firstName);
        employee.setId(Long.valueOf(id));
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setRole(Role.valueOf(request.getParameter("role")));
        employee.setContact(contact);
        employee.getAddresses().add(new Address(street,city,employee));
        EmployeeImp employeeImp =new EmployeeImp();
        try {
            employee=  employeeImp.updateElement(employee);

            context.setVariable("success", "Employee has ben Updated !");
            response.sendRedirect(request.getContextPath() + "/employee");

        }catch (Exception e){
            if(employee.getId() == null){
                context.setVariable("error", "Employee Not Updated");
                engine.process("updateEmployee.html", context, response.getWriter());
            }

        }
    }
}
*/