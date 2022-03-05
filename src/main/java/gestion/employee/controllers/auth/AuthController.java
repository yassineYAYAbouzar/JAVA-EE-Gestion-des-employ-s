package gestion.employee.controllers.auth;

import gestion.employee.Dae.EmployeeImp;
import gestion.employee.Entities.Employee;
import gestion.employee.repository.EmployeeRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
@SessionAttributes({"sessionEmployee"})
public class AuthController {
    EmployeeRepositoryImp employeeRepositoryImp = new EmployeeRepositoryImp();
    EmployeeImp employeeImp;
    @Autowired
    public AuthController(EmployeeImp employeeImp) {
        this.employeeImp = employeeImp;
    }


    @GetMapping("/")
    public String loginForm(@ModelAttribute("employee") Employee employee ) {

        return "login";
    }
    @GetMapping("/employee/logout")
    public String logout(HttpSession session ) {
        session.invalidate();
        return "redirect:/";
    }

    //login employee
    @PostMapping("/login")
    public String login(@ModelAttribute("employee") Employee employee , Model model , HttpSession session) {
        try {
           Employee employee1= employeeRepositoryImp.findByEmailAndPassword(employee.getEmail(),employee.getPassword());
            session.setAttribute("sessionEmployee", employee1);
        }catch (Exception e){
            model.addAttribute("error", "Login failed! Error in email or password");
            return "login";
        }
        return "redirect:/employee/";
    }

    //showEmployee employee
    @GetMapping("/showProfile/{employeId}")
    public String showProfile(@ModelAttribute("employee") Employee employee ,@RequestParam("employeId") String employeeId,
                               Model model) {
        model.addAttribute("employee", employeeImp.getElementById(employeeId));

        return "profileEmployee";
    }

}


