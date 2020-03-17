package com.swj.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 孙文举
 * @description
 * @create 2020-03-17 16:37
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
            return true; //放行
        }
        //拦截住,到登录页面重新登录
        request.getRequestDispatcher("/").forward(request, response);
        return false;
    }
}