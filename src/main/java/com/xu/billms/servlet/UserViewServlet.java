package com.xu.billms.servlet;

import com.xu.billms.entity.User;
import com.xu.billms.service.UserService;
import com.xu.billms.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 显示单个用户信息
 *
 * @author xu
 * @date 28/9/2019 上午1:42
 */
@WebServlet("/userview")
public class UserViewServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        // 2.根据ID获取修改的用户信息
        User user = userService.findById(id);
        // 3. 把用户信息显示到页面中
        req.setAttribute("user",user);
        req.getRequestDispatcher("/userView.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
