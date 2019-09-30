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

/**
 * 根据id显示账单信息
 *
 * @author xu
 * @date 28/9/2019 上午2:07
 */
@WebServlet("/billview")
public class BillViewServlet extends HttpServlet {
    private BillService billService = new BillServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取提交的参数
        String id = req.getParameter("id");
        // 2.根据ID获取修改的图书信息
        Bill bill = billService.findById(id);
        // 3. 把图书信息显示到页面中
        req.setAttribute("bill",bill);
        req.getRequestDispatcher("/billView.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
