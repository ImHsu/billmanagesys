package com.xu.billms.servlet;

import com.xu.billms.entity.User;
import com.xu.billms.service.LoginService;
import com.xu.billms.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 返回所有用户信息数据并到jsp显示
 *
 * @author xu
 * @date 26/9/2019 上午9:32
 */
@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {

    private LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取所有的用户
        List<User> list = loginService.getAll();
        // 2.把用户列表存入到request域中,方便在页面通过jstl和el获取
        req.setAttribute("list", list);
        //3.重定向
        req.getRequestDispatcher("/userList.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
