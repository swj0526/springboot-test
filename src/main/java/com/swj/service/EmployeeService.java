package com.swj.service;

import com.swj.dao.EmployeeDao;
import com.swj.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author 孙文举
 * @description
 * @create 2020-03-17 23:34
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public Collection<Employee> employeeList() {
        Collection<Employee> list = employeeDao.getList();
        return list;
    }

    public void updateOrAdd(Employee employee) {
        employeeDao.add(employee);
    }

    public Employee getEmployee(int id) {
        return employeeDao.getEmployeeById(id);
    }
    public void delete(int id){
        employeeDao.delete(id);
    }
}