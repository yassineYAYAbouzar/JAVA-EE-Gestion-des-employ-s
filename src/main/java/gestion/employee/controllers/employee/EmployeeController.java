package gestion.employee.controllers.employee;

import gestion.employee.Entities.Address;
import gestion.employee.Entities.Employee;
import gestion.employee.Entities.Role;
import gestion.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @ModelAttribute("roleList")
    private List<Role> roleList(){
        List<Role> roleList = new ArrayList<>() ;
        roleList.add(Role.ADMIN);
        roleList.add(Role.EMPLOYEE);
        return  roleList;
    }



    @GetMapping("/")
    public String getAllEmployee(Model model) {
        model.addAttribute("admin" , Role.ADMIN);
        model.addAttribute("employeeList",employeeService.getUsers());
        return "employee";
    }

    @GetMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee  ) {
        return "addEmployee";
    }

    //Save employee
    @PostMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("error" , "employee not saved");
            return "addEmployee";
        }
        employeeService.saveUser(employee);
        redirectAttributes.addFlashAttribute("success" , "employee saved");
        return "redirect:/employee/";

    }

    //showEmployee employee
    @GetMapping("/show/{employeId}")
    public String showEmployee(@ModelAttribute("employee") Employee employee ,@RequestParam("employeId") String employeeId,
                                    Model model) {
        model.addAttribute("employee", employeeService.getEmployee(employeeId));

        return "showEmployee";
    }
    //Update employee
    @GetMapping("/update/{employeId}")
    public String showFormForUpdate(@RequestParam("employeId") String employeeId,
                                    Model model) {
        model.addAttribute("employee",employeeService.getEmployee(employeeId));
        return "updateEmployee";
    }

    //Save employee
    @PostMapping("/updateEmployee")
    public String updateEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            return "updateEmployee";
        }else {
            employeeService.updateElement(employee);
            redirectAttributes.addFlashAttribute("success" , "employee saved");
            return "redirect:/employee/";
        }

    }
    //Delete employee
    @GetMapping(path = "/{employeId}")
    public String deleteUser(@RequestParam("employeId") String employeId) {
        employeeService.deleteUser(employeId);
        return "redirect:/employee/";
    }
}


