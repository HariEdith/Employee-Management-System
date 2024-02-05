package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("allemplist", employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/add")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "addEmployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("updateform/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model){
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") long id){
        employeeService.deleteById(id);
        return "redirect:/";
    }

    // Authentication logic
    @PostMapping("/authenticate")
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        // Replace this with your actual authentication logic
        // Example: Check if the provided username and password are valid
        if ("john".equals(username) && "password".equals(password)) {
            return "redirect:/index";
        } else {
            return "redirect:/login?error=true";
        }
    }
}
