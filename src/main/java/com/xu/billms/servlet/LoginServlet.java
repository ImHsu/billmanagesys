package com.xu.billms.servlet;

import com.xu.billms.service.LoginService;
import com.xu.billms.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录
 *
 * @author xu
 * @date 25/9/2019 下午10:18
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String REMEMBER = "remember";

    private LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String UN = null;
        String PWD = null;
        //设置请求编码
        resp.setCharacterEncoding("UTF-8");
        //设置响应正文类型
        resp.setContentType("text/html;charset=utf8");
        //获取请求参数
        String username = req.getParameter(USERNAME);
        String password = req.getParameter(PASSWORD);
        String remember = req.getParameter(REMEMBER);

        boolean flag = false;
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                //4.判断名称是否是USERNAME,USERNAME
                if ("USERNAME".equals(cookieName)) {
                    //获取Cookie的value，时间
                    UN = cookie.getValue();
                    flag = true;
                } else if ("PASSWORD".equals(cookieName)) {
                    PWD = cookie.getValue();
                }
            }
            System.out.println("UN:" + UN);
            System.out.println("PWD:" + PWD);
            if (UN != null && PWD != null) {
                boolean login = loginService.login(UN, PWD, remember, req, resp);
                if (login) {
                    req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
                }
            }
        }







        // 2.把获取的数据交个service处理
        boolean loginRes = loginService.login(username, password, remember, req, resp);
        // 3.根据处理的结果跳转到相应的页面
        if (loginRes) {
            Cookie cookie1 = new Cookie("USERNAME", username);
            cookie1.setMaxAge(60 * 30);
            resp.addCookie(cookie1);

            if (remember != null) {
                //创建cookie对象
                Cookie cookie2 = new Cookie("PASSWORD", password);
                Cookie cookie3 = new Cookie("USERNAME", username);
                //设置一下存活时间
                cookie2.setMaxAge(60 * 60 * 24 * 7);
                cookie1.setMaxAge(60 * 60 * 24 * 7);
                //发送cookie
                resp.addCookie(cookie2);
                resp.addCookie(cookie3);
            }

            req.getSession().setAttribute("username", username);
            // 成功跳转到欢迎页面,使用重定向到欢迎页面
            resp.sendRedirect(req.getContextPath() + "/welcome.jsp");
        } else {
            // 失败就回到登陆页面,提示"用户名或密码错误!",使用请求转发
            // 存入错误信息
            req.setAttribute("error", "用户名或密码错误!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
