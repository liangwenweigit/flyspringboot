package com.fly.flyspringboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.fly.flyspringboot.domain.JsonData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录拦截器
 * @author liang
 * @date 2019/2/1 - 22:33
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 进入controller之前拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");//在获取参数里面的token看看有没有
        if (token == null){
        	System.err.println("token为空放行...");
                return true;
        }
        //来到这里表示拦截
        System.err.println("拦截...");
        return false;
    }
}
