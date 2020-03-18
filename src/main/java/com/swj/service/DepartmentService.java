package com.swj.service;

import com.swj.dao.DepartmentDao;
import com.swj.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author 孙文举
 * @description
 * @create 2020-03-18 17:10
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public Collection<Department> getList() {
        return departmentDao.getList();
    }
}