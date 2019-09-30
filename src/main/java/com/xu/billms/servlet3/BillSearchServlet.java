package com.xu.billms.servlet3;

import com.xu.billms.entity.Bill;
import com.xu.billms.service.BillService;
import com.xu.billms.service.impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 账单搜索
 *
 * @author xu
 * @date 27/9/2019 上午11:21
 */
@WebServlet("/billsearch")
public class BillSearchServlet extends HttpServlet {
    private BillService billService = new BillServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 获取所有的参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 调用方法并返回集合
        List<Bill> list = billService.selectByParams(parameterMap);
        req.setAttribute("list", list);
        // 请求转发
        req.getRequestDispatcher("/billList.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
