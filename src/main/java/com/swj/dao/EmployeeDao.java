package com.swj.dao;

import com.swj.domain.Department;
import com.swj.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author 孙文举
 * @description
 * @create 2020-03-14 18:01
 */
@Repository
public class EmployeeDao { //初始化职工数据

    private static HashMap<Integer, Employee> employeeTable; //用一个map对象来单做一个表
    private static int id = 5;//初始的新增
    @Autowired
    private DepartmentDao departmentDao;//注入部门dao.新增数据的时候需要用到

    //初始化数据
    static {
        employeeTable = new HashMap<Integer, Employee>();
        employeeTable.put(1, new Employee(1, 18, "于屁屁1号~", new Department(1, "教育部")));
        employeeTable.put(2, new Employee(2, 22, "于屁屁2号~", new Department(2, "宣传部")));
        employeeTable.put(3, new Employee(3, 43, "于屁屁3号~", new Department(3, "策划部")));
        employeeTable.put(4, new Employee(4, 26, "于屁屁4号~", new Department(4, "教研部")));
        employeeTable.put(5, new Employee(5, 12, "于屁屁5号~", new Department(5, "后勤部")));

    }

    //新增数据的时候要有主键新增
    public int key() {
        id++;
        return id;
    }

    //新增
    public void add(Employee employee) {
        employee.setId(key());
        long id = employee.getDepartment().getId();//获取部门id;
        employee.setDepartment(departmentDao.getDepartmentById(id));
        employeeTable.put(key(), employee);
    }

    //删除
    public void delete(long id) {
        employeeTable.remove(id);
    }

    //修改
    public void update(Employee employee) {
        Employee employeeDB = employeeTable.get(employee.getId());
        employeeDB.setDepartment(employee.getDepartment());
        employeeDB.setAge(employee.getAge());
        employeeDB.setName(employee.getName());
        employeeTable.remove(employee.getId());
        employeeTable.put((int) employee.getId(), employeeDB);
    }

    //查询所有数据
    public Collection<Employee> getList() {
        return employeeTable.values();
    }

    //查询某一个数据
    public Employee getEmployeeById(long id) {
        return employeeTable.get(id);
    }
}