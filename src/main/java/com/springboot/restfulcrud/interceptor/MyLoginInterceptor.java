package com.springboot.restfulcrud.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 配置拦截器
 */
public class MyLoginInterceptor implements HandlerInterceptor {

    /**
     * 配置拦截器，判断session中有没有loggedUser，有则放行，无则拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loggedUser");
        if(user == null){
            //无登录用户则拦截
            //先添加消息到msg中，再转发请求
            request.setAttribute("msg","没有权限访问，请先登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else {
            /*有登录用户则放行*/
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
