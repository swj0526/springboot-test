package com.swj.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 孙文举
 * @description
 * @create 2020-03-14 17:57
 */
@Data
@AllArgsConstructor
public class Department { //部门类
    private long id;
    private String name;
}