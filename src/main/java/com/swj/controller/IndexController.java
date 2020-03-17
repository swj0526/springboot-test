package com.swj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 孙文举
 * @description
 * @create 2020-03-16 9:48
 */
@Controller
public class IndexController {

    @RequestMapping("/loginCheck")
    public String loginCheck(String userName, String passWord, HttpSession session, HttpServletRequest request) {
        if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(passWord)) {
            if (passWord.equals("123456")) {
                session.setAttribute("user", userName);
                return "redirect:/home";//使用重定向,防止表单重复提交
                //如果不使用重定向,url地址就是这个controller的地址,一刷新这个页面,controller就会在请求一遍
                //使用了重定向,页面在自动请求一个新页面,url地址变了,在刷新也不存在这个问题
                // 但是!!!重定向后面跟的是controller地址
                //我们这个时候可以在mvc配置类里写试图跳转,这样就不用在单独写controller了
            }
            request.setAttribute("msg", "密码错误!");
            return "/";
        }
        request.setAttribute("msg", "用户名或密码为空!");
        return "/";
    }
}