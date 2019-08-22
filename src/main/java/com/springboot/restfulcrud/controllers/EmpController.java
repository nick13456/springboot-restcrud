package com.springboot.restfulcrud.controllers;

import com.springboot.restfulcrud.dao.EmployeeDao;
import com.springboot.restfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmpController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employees")
    public String employees(Model model){
       Collection<Employee> employees = employeeDao.getAll();
       model.addAttribute("employees",employees);
       return "employee/list";
    }
}
