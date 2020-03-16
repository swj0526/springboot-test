package com.swj;

import com.swj.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootTestApplicationTests {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void contextLoads() {
        System.out.println(employeeDao.getList());

    }

}
