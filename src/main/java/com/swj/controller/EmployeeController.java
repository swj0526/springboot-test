package com.swj.controller;

import com.swj.domain.Employee;
import com.swj.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * @author 孙文举
 * @description
 * @create 2020-03-17 22:59
 */
@Controller
public class EmployeeController {

@Autowired
private EmployeeService employeeService;
    @RequestMapping("/employeeList")
    public String employeeList(ModelAndView model) {
        Collection<Employee> employees = employeeService.employeeList();
        model.addObject("employees",employees);
        return "/list";
    }
}