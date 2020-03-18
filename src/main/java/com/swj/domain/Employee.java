package com.swj.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 孙文举
 * @description
 * @create 2020-03-14 17:50
 */
@Data
public class Employee { //员工类
    private Integer id;
    private int age;
    private int sex;
    private String name;
    private Date date; //入职时间
    private Department department;

    public Employee(Integer id, int age, String name, Department department, int sex) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.date = new Date();
        this.department = department;
        this.sex = sex;
    }
}