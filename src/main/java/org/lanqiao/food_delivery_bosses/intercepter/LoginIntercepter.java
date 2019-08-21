package org.lanqiao.food_delivery_bosses.intercepter;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        if(!StringUtils.isEmpty(username)){
            return  true;
        }
        request.getRequestDispatcher("/index.html").forward(request,response);
        return false;
    }
}
