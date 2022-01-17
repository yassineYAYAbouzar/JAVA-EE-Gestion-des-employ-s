package Presentation;

import Dae.EmployeeImp;
import Entities.Employee;
import Presentation.config.ThymleafConfig;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import repository.EmployeeRepositoryImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Presentation.ShowEmployeeServlet" , urlPatterns =  "/employee/show")
public class ShowEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateEngine engine = ThymleafConfig.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        EmployeeImp employeeImp = new EmployeeImp();
        Employee employee = null;
        try {
            employee = employeeImp.getElementById(Integer.parseInt(request.getParameter("employeId")));

            context.setVariable("employee", employee);
            engine.process("showEmployee.html", context, response.getWriter());

        } catch (Exception e) {
            if (employee.getId() == null) {
                context.setVariable("error", " No Employee Yet");
                response.sendRedirect(request.getContextPath() + "/employee");
            }

        }


    }
}

