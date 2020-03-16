package com.swj.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 孙文举
 * @description
 * @create 2020-03-14 17:50
 */
@Data
@ToString
public class Employee { //员工类
    private  long id;
    private  int age;
    private  String name;
    private Date date; //入职时间
    private Department department;

    public Employee(long id, int age, String name, Department department) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.date = new Date();
        this.department = department;
    }
}