package gestion.employee.controllers.auth;

import gestion.employee.Entities.Employee;
import gestion.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
@SessionAttributes({"sessionEmployee"})
public class UserController {
    @Autowired
    private EmployeeService employeeService;


   //get Login Page
    @GetMapping("/")
    public String loginForm(@ModelAttribute("employee") Employee employee ) {
        return "login";
    }

    //login employee
    @PostMapping("/login")
    public String login(@ModelAttribute("employee") Employee employee , Model model , HttpSession session) {
        try {
            session.setAttribute("sessionEmployee", employeeService.findByEmailAndPassword(employee.getEmail(),employee.getPassword()));
        }catch (Exception e){
            model.addAttribute("error", "Login failed! Error in email or password");
            return "login";
        }
        return "redirect:/employee/";
    }

    //showEmployee profile
    @GetMapping("/profile/{employeId}")
    public String showProfile(@ModelAttribute("employee") Employee employee ,@RequestParam("employeId") String employeeId,
                               Model model) {
        model.addAttribute("employee", employeeService.getEmployee(employeeId));

        return "profileEmployee";
    }
    //updatePassword employee
    @PostMapping("/updatePassword")
    public String updatePassword(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            return "addEmployee";
        }else {
            employeeService.changePassword(employee.getEmail() , employee.getPassword());
            redirectAttributes.addFlashAttribute("success" , "password updated !");
            return "redirect:/employee/";
        }

    }
    //logout
    @GetMapping("/employee/logout")
    public String logout(HttpSession session ) {
        session.invalidate();
        return "redirect:/";
    }
}


