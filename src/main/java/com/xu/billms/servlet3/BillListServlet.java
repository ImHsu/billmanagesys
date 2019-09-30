package com.xu.billms.servlet3;

import com.xu.billms.entity.Bill;
import com.xu.billms.entity.Supplier;
import com.xu.billms.service.BillService;
import com.xu.billms.service.SupplierService;
import com.xu.billms.service.impl.BillServiceImpl;
import com.xu.billms.service.impl.SupplierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账单列表显示
 * 冲数据返回所有账单数据
 *
 * @author xu
 * @date 26/9/2019 上午10:59
 */
@WebServlet("/billlist")
public class BillListServlet extends HttpServlet {
    private BillService billService = new BillServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取所有的账单
        List<Bill> list = billService.getAll();
        // 2.把图书列表存入到request域中,方便在页面通过jstl和el获取
        req.setAttribute("list", list);
        //请求转发并显示
        req.getRequestDispatcher("/billList.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
