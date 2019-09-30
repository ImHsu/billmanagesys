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
import java.util.List;

/**
 * 用户信息搜索
 *
 * @author xu
 * @date 26/9/2019 下午5:11
 */
@WebServlet("/usersearch")
public class UserSearchServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        List<User> list = userService.selectByName(name);
        req.setAttribute("list", list);
        req.getRequestDispatcher("/userList.jsp").forward(req,resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
