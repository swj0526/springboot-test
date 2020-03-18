package com.swj.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author 孙文举
 * @description
 * @create 2020-03-14 17:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department { //部门类
    private Integer id;
    private String name;
}