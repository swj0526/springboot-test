package com.swj.dao;

import com.swj.domain.Department;
import com.swj.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author 孙文举
 * @description
 * @create 2020-03-14 18:01
 */
@Repository
public class DepartmentDao { //初始化部门数据

    private static HashMap<Integer, Department> departmentTable; //用一个map对象来单做一个表
    private static int id = 5;//初始的新增

    //初始化数据
    static {
        departmentTable = new HashMap<Integer, Department>();
        departmentTable.put(1, new Department(1, "教育部"));
        departmentTable.put(2, new Department(2, "宣传部"));
        departmentTable.put(3, new Department(3, "策划部"));
        departmentTable.put(4, new Department(4, "教研部"));
        departmentTable.put(5, new Department(5, "后勤部"));

    }

    //新增数据的时候要有主键新增
    public int key() {
        id++;
        return id;
    }

    //新增
    public void add(Department department) {
        department.setId(key());
        departmentTable.put(key(), department);
    }

    //修改
    public void update(Department department) {
        Department departmentDB = departmentTable.get(department.getId());
        departmentDB.setName(department.getName());
        departmentTable.remove(department.getId());
        departmentTable.put((int) department.getId(), departmentDB);

    }

    //删除
    public void delete(long id) {
        departmentTable.remove(id);
    }

    //根据id查询
    public Department getDepartmentById(long id) {
        Department departmentDB = departmentTable.get(id);
        return departmentDB;
    }

    //返回所有数据
    public Collection<Department> getList() {
        return departmentTable.values();
    }
}