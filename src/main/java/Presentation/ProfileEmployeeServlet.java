package Presentation;

import DataAccess.Dae.EmployeeImp;
import DataAccess.Entities.Employee;
import DataAccess.repository.EmployeeRepositoryImp;
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

@WebServlet(name = "Presentation.ProfileEmployeeServlet" , urlPatterns =  "/employee/profile")
public class ProfileEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      TemplateEngine engine = ThymleafConfig.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request,response,request.getServletContext());

        EmployeeImp employeeImp = new EmployeeImp();
        Employee employee = null;
        try {
             employee=  employeeImp.getElementById(Integer.parseInt(request.getParameter("employeId")));

            context.setVariable("employee", employee);
            engine.process("profileEmployee.html" ,context ,response.getWriter());

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
            request.getRequestDispatcher("/employee").forward(request, response);

        }catch (Exception e){
           if(employee != 1){
                context.setVariable("error", "Employee Not Updated");
                engine.process("updateEmployee.html", context, response.getWriter());
            }

        }
    }
    }

