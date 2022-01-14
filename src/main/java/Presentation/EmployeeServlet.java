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

@WebServlet(name = "Presentation.EmployeeServlet" , urlPatterns ="/employee")
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateEngine engine = ThymleafConfig.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request,response,request.getServletContext());
        HttpSession session = request.getSession();

        context.setVariable("sessionEmployee", session.getAttribute("sessionEmployee"));
        System.out.println(session.getAttribute("sessionEmployee"));
        EmployeeImp employeeImp = new EmployeeImp();
        List<Employee> employeeList =employeeImp.selectAllElements();
        List<Role> roleList = new ArrayList<>();

        context.setVariable("admin",Role.ADMIN);
        context.setVariable("roleList",roleList);
        context.setVariable("employee",session.getAttribute("employee"));
        context.setVariable("employeeList",employeeList);
        engine.process("employee.html" ,context ,response.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
