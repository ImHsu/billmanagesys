package com.xu.billms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 退出
 * 删除Cookie,Session
 *
 * @author xu
 * @date 28/9/2019 上午12:58
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if ("USERNAME".equals(cookieName)) {
                    //删除cookie
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                } else if ("PASSWORD".equals(cookieName)) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
            }
        }
        // 退出,请求session,返回登陆页面
        HttpSession session = req.getSession();
        // 移除某个值
        session.removeAttribute("username");
        // 销毁session
        session.invalidate();
        // 重定向
        resp.sendRedirect(req.getContextPath() + "/login.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
