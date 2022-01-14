package Presentation;

import DataAccess.Dae.EmployeeImp;
import DataAccess.Entities.Employee;
import DataAccess.Role;
import Presentation.config.ThymleafConfig;
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

@WebServlet(name = "Presentation.UpdateEmployeeServlet" , urlPatterns =  "/employee/update")
public class UpdateEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      TemplateEngine engine = ThymleafConfig.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request,response,request.getServletContext());

        EmployeeImp employeeImp = new EmployeeImp();
        Employee employee = null;
        try {
             employee=  employeeImp.getElementById(Integer.parseInt(request.getParameter("employeId")));
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


        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setId(Long.valueOf(id));
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setRole(Role.EMPLOYEE);
        EmployeeImp employeeImp =new EmployeeImp();
        try {
            employee=  employeeImp.updateElement(employee);

            context.setVariable("success", "Employee has ben Updated !");
            request.getRequestDispatcher("/employee").forward(request, response);

        }catch (Exception e){
            if(employee.getId() == null){
                context.setVariable("error", "Employee Not Updated");
                engine.process("updateEmployee.html", context, response.getWriter());
            }

        }
    }
}
