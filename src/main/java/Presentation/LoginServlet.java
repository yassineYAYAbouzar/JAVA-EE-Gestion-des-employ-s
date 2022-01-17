package Presentation;

import Entities.Employee;
import repository.EmployeeRepositoryImp;
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

@WebServlet(name = "Presentation.LoginServlet" , urlPatterns = {"/" , "/login/auth"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateEngine engine = ThymleafConfig.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request,response,request.getServletContext());
        engine.process("login.html" ,context ,response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateEngine engine = ThymleafConfig.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        EmployeeRepositoryImp employeeRepositoryImp = new EmployeeRepositoryImp();
        Employee employee=new Employee() ;
        try {
             employee = employeeRepositoryImp.findByEmailAndPassword(email,password);

             HttpSession session = request.getSession(true);
             session.setAttribute("sessionEmployee", employee);
             response.sendRedirect(request.getContextPath() + "/employee");
        }catch (Exception e){
           context.setVariable("error", "Login failed! Error in email or password");
           engine.process("login.html", context, response.getWriter());
        }


    }

}
