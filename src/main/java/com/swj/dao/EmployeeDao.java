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
        employeeTable.put(1, new Employee(1, 18, "于屁屁1号~", new Department(1, "教育部"), 0));
        employeeTable.put(2, new Employee(2, 22, "于屁屁2号~", new Department(2, "宣传部"), 0));
        employeeTable.put(3, new Employee(3, 43, "于屁屁3号~", new Department(3, "策划部"), 1));
        employeeTable.put(4, new Employee(4, 26, "于屁屁4号~", new Department(4, "教研部"), 1));
        employeeTable.put(5, new Employee(5, 12, "于屁屁5号~", new Department(5, "后勤部"), 1));

    }

    //新增数据的时候要有主键新增
    public Integer key() {
        ++id;
        return id;
    }

    //新增 ,修改共用,因为用的map集合,只要有一个相同的id,就会替换原来的数据
    public void add(Employee employee) {
        if (employee.getId() != null) { //不等0,就代表就是有修改
            Integer id = employee.getDepartment().getId();//获取部门id;
            employee.setDepartment(departmentDao.getDepartmentById(id));
            employeeTable.put(employee.getId(), employee);
        } else {
            employee.setId(key());
            Integer id = employee.getDepartment().getId();//获取部门id;
            employee.setDepartment(departmentDao.getDepartmentById(id));
            employeeTable.put(employee.getId(), employee);
        }
    }

    //删除
    public void delete(Integer id) {
        employeeTable.remove(id);
    }


    //查询所有数据
    public Collection<Employee> getList() {
        return employeeTable.values();
    }

    //查询某一个数据
    public Employee getEmployeeById(Integer id) {
        return employeeTable.get(id);
    }
}