package com.swj.controller;

import com.swj.domain.Department;
import com.swj.domain.Employee;
import com.swj.service.DepartmentService;
import com.swj.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/employeeList")
    public String employeeList(Model model) {
        Collection<Employee> employees = employeeService.employeeList();
        model.addAttribute("employees", employees);
        System.out.println("bug==>"+employees);
        return "employee/list";  //只要是return,就不要加/.除非重定向
    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(Model model, @PathVariable("id") Integer id) {
        Employee employee = employeeService.getEmployee(id);
        Collection<Department> departments = departmentService.getList();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments);
        return "employee/update";  //只要是return,就不要加/.除非重定向
    }
    @RequestMapping("/toAdd")
    public String toAdd(Model model) {
        Collection<Department> departments = departmentService.getList();
        model.addAttribute("departments", departments);
        return "employee/add";  //只要是return,就不要加/.除非重定向
    }
    @RequestMapping("/toDelete/{id}")
    public String toDelete(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return "redirect:/employeeList";  //只要是return,就不要加/.除非重定向
    }

    @RequestMapping("/addOrUpdate") //添加修改数据共用一个
    public String addOrUpdate(Employee employee) {
        employeeService.updateOrAdd(employee);
        return "redirect:/employeeList";
    }
}