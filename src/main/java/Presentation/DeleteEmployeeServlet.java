package Presentation;

import Dae.EmployeeImp;
import Presentation.config.ThymleafConfig;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Presentation.DeleteEmployeeServlet" , urlPatterns = "/employee/delete")
public class DeleteEmployeeServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateEngine engine = ThymleafConfig.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request,response,request.getServletContext());



        EmployeeImp employeeImp =new EmployeeImp();
        Boolean deleted =false;
        try {
            String userId = request.getParameter("userId");
            System.out.println(userId);
             deleted = employeeImp.deleteElement(userId);
             context.setVariable("success", "Employee has ben deleted !");
            response.sendRedirect(request.getContextPath() + "/employee");

        }catch (Exception e){
            if(deleted == false){
                context.setVariable("error", "Employee Not deleted");
                engine.process("employee.html", context, response.getWriter());
            }

        }
    }
}
