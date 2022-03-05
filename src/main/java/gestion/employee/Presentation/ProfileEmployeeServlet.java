/*package gestion.employee.Presentation;

import gestion.employee.Dae.EmployeeImp;
import gestion.employee.Entities.Employee;
import gestion.employee.Presentation.config.ThymleafConfig;
import gestion.employee.repository.EmployeeRepositoryImp;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "Presentation.ProfileEmployeeServlet" , urlPatterns =  "/employee/profile")
public class ProfileEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      TemplateEngine engine = ThymleafConfig.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request,response,request.getServletContext());

        EmployeeImp employeeImp = new EmployeeImp();
        Employee employee = null;
        try {
             employee=  employeeImp.getElementById(request.getParameter("employeId"));

            context.setVariable("employee", employee);
            engine.process("profileEmployee.html" ,context ,response.getWriter());

        }catch (Exception e){
            if(employee.getId() == null){
                context.setVariable("error", " No Employee Yet");
                response.sendRedirect(request.getContextPath() + "/employee");
            }

        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateEngine engine = ThymleafConfig.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request,response,request.getServletContext());
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");


        EmployeeRepositoryImp employeeRepositoryImp = new EmployeeRepositoryImp();
        employeeRepositoryImp.changePassword(email ,password);
        int  employee = 0;
        try {
            employee=  employeeRepositoryImp.changePassword(email ,password);
             System.out.println(employee);
            context.setVariable("success", "Employee has ben Updated !");
            response.sendRedirect(request.getContextPath() + "/employee");

        }catch (Exception e){
           if(employee != 1){
                context.setVariable("error", "Employee Not Updated");
                engine.process("updateEmployee.html", context, response.getWriter());
            }

        }
    }
    }

*/