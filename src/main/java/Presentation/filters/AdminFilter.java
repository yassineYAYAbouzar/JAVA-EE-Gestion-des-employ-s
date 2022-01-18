package Presentation.filters;

import Entities.Employee;
import Entities.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebFilter(urlPatterns = {"/employee/add" , "/employee/update" ,"/employee/delete" })
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
           System.out.println("runn");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        System.out.println("helllo"+session.getAttribute("sessionEmployee"));
        Employee admin =(Employee) session.getAttribute("sessionEmployee");
        System.out.println(admin.getRole());
        if(admin.getRole() != Role.ADMIN){
            //request.getRequestDispatcher("/login").forward(request, servletResponse);
            response.sendRedirect(request.getContextPath() + "/employee");
        }else{
            filterChain.doFilter(request,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
