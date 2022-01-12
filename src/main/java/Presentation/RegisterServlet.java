package Presentation;

import Presentation.config.ThymleafConfig;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Presentation.RegisterServlet" , urlPatterns = {"/" , "/index"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Presentation.RegisterServlet Started !");

        TemplateEngine engine = ThymleafConfig.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request,response,request.getServletContext());
        context.setVariable("salam","yassine");
        engine.process("register.html" ,context ,response.getWriter());
    }
}
