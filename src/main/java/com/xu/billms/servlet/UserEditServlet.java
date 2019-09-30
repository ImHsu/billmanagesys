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
 * ${Description}
 *
 * @author xu
 * @date 26/9/2019 下午2:06
 */
@WebServlet("/useredit")
public class UserEditServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取提交的参数
        String id = req.getParameter("id");
        // 2.根据ID获取修改的用户信息
        User user = userService.findById(id);
        // 3. 把用户信息显示到页面中
        req.setAttribute("user",user);
        req.getRequestDispatcher("/userUpdate.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
