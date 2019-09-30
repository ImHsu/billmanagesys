package com.xu.billms.fliter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ${Description}
 *
 * @author xu
 * @date 27/9/2019 下午4:24
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("进入拦截器");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 获取当前的请求路径
        String uri = request.getRequestURI();



        String UN= null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                //4.判断名称是否是USERNAME,USERNAME
                if ("USERNAME".equals(cookieName)) {
                    UN = cookie.getValue();
                }
            }
        }



        if (uri.contains("/login.jsp") || uri.contains("/login")){
            chain.doFilter(req, resp);
        }else {
            if (UN == null){
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }else{
                chain.doFilter(req, resp);
            }
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
