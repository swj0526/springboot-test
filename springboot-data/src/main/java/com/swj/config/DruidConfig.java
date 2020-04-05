package com.swj.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙文举
 * @description
 * @create 2020-04-05 18:12
 */
@Configuration
public class DruidConfig {
    //把yml的数据文件跟配置类进行绑定,这样我们就可以用yml中的配置了
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");//访问页面
        Map<String, String> initParameters = new HashMap<>();
        //initParameters put 的所有key 都是固定的人家写好的
        initParameters.put("loginUsername", "admin"); //loginUsername  键是固定的
        initParameters.put("loginPassword", "123");//loginPassword key  键是固定的
        //允许谁可以访问
        initParameters.put("allow", "");//默认允许所有
        bean.setInitParameters(initParameters);//设置初始化参数
        return bean;
    }
}



