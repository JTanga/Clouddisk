package cn.tangtj.clouddisk.annotation;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *自定义拦截器
 *实现HandlerInterceptor接口
 **/
@Component
public class SourceAccessInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器了");
        // 反射获取方法上的LoginInterceptor注解
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        LoginInterceptor loginInterceptor = handlerMethod.getMethod().getAnnotation(LoginInterceptor.class);
        if(loginInterceptor == null){
            return true;
        }

        // 有LoginInterceptor注解说明需要登录，提示用户登录
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().print("你访问的资源沒有权限");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
