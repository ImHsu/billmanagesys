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
 * 修改密码,当前已登录用户的密码
 *
 * @author xu
 * @date 27/9/2019 下午4:55
 */
@WebServlet("/updatepassword")
public class UpdatePasswordServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("UTF-8");
        // 获取所有的参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 调用方法返回结果
        boolean res = userService.updatePwd(parameterMap, req, resp);
        if (res){
            req.setAttribute("error", "密码修改成功!");
            req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
        }else {
            req.setAttribute("error", "密码修改失败!");
            req.getRequestDispatcher("/password.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
