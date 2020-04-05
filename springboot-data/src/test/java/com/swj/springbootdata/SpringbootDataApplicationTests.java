package com.swj.springbootdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootDataApplicationTests {
    @Autowired
    DataSource dataSource; //注入数据源
    @Test
    void contextLoads() throws SQLException {

        System.out.println(dataSource.getClass());
        //数据源:class com.alibaba.druid.pool.DruidDataSource
        //获得数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }

}
