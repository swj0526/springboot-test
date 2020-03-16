package com.swj.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author 孙文举
 * @description
 * @create 2020-03-16 19:14
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override //解析请求
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");//获取请求参数
        Locale locale = Locale.getDefault();//如果没有就使用默认方式
        if (!StringUtils.isEmpty(l)) {
            //zh_CN
            String[] split = l.split("_");
            //国家,地区
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}