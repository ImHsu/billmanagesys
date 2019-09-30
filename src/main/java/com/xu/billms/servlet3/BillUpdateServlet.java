package com.xu.billms.servlet3;

import com.xu.billms.service.BillService;
import com.xu.billms.service.impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 对账单进行修改
 *
 * @author xu
 * @date 26/9/2019 下午11:18
 */
@WebServlet("/billupdate")
public class BillUpdateServlet extends HttpServlet {

    private BillService billService = new BillServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符编码
        req.setCharacterEncoding("UTF-8");
        // 获取所有的参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 调用方法
        billService.update(parameterMap);
        resp.sendRedirect(req.getContextPath() + "/billlist");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
