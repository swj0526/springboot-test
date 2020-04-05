package com.swj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 孙文举
 * @description
 * @create 2020-04-05 9:58
 */
@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库的所有信息
    //没有实体类,数据库中的东西,怎么获取?map
    @RequestMapping("/userList")
    public List<Map<String, Object>> userList() {
        String sql = "select *  from  mybatis.tbuser";
        List<Map<String, Object>> list_map = jdbcTemplate.queryForList(sql);
        return list_map;
    }

    @RequestMapping("/addUser")
    public String addUser() {
        String sql = "insert into mybatis.tbuser (name,pwd,teaId) values ('小明','234',1)";
        jdbcTemplate.update(sql);
        return "ok";
    }

    @RequestMapping("/updateUser/{id}/{pwd}")
    public String updateUser(@PathVariable("id") int id, @PathVariable("pwd") String pwd) {
        String sql = "update mybatis.tbuser set pwd =? where  id= ?";
        Object[] object = new Object[2];
        object[0] = pwd;
        object[1] = id;
        jdbcTemplate.update(sql, object);
        return "ok";
    }
}