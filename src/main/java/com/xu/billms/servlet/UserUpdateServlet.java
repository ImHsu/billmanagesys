package com.xu.billms.servlet;

import com.xu.billms.service.UserService;
import com.xu.billms.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 跟新用户信息
 *
 * @author xu
 * @date 26/9/2019 上午11:55
 */
@WebServlet("/userupdate")
public class UserUpdateServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("UTF-8");
        // 获取所有的参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 调用方法
        userService.update(parameterMap);
        // 返回列表
        resp.sendRedirect(req.getContextPath()+"/userlist");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
