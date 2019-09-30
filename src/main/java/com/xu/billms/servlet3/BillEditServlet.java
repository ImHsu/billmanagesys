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

/**
 * 对账单修改时候需要进行编辑
 * 对数据进行编辑修改
 *
 * @author xu
 * @date 26/9/2019 下午11:17
 */
@WebServlet("/billedit")
public class BillEditServlet extends HttpServlet {

    private BillService billService = new BillServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取提交的id
        String id = req.getParameter("id");
        System.out.println(id);
        // 2.根据ID获取修改的账单信息
        Bill bill = billService.findById(id);
        // 3. 把账单信息显示到页面中方便修改
        req.setAttribute("bill",bill);
        // 4.请求转发
        req.getRequestDispatcher("/billUpdate.jsp").forward(req,resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
