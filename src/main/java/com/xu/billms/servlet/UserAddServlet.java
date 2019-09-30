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
 * 用户添加
 *
 * @author xu
 * @date 26/9/2019 下午4:08
 */
@WebServlet("/useradd")
public class UserAddServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Map<String, String[]> params = req.getParameterMap();
        int saveRes = userService.save(params);
        if (saveRes>0){
            resp.sendRedirect(req.getContextPath()+"/userlist");
        } else {
            //用户重复返回提示
            req.setAttribute("error", "用户名已注册,请重新输入!");
            req.getRequestDispatcher("/userAdd.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
