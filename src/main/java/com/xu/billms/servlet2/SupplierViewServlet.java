package com.xu.billms.servlet2;

import com.xu.billms.entity.Supplier;
import com.xu.billms.service.SupplierService;
import com.xu.billms.service.impl.SupplierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 根据id显示供应商信息
 *
 * @author xu
 * @date 28/9/2019 上午1:55
 */
@WebServlet("/supplierview")
public class SupplierViewServlet extends HttpServlet {
    private SupplierService supplierService = new SupplierServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        // 2.根据ID获取修改的图书信息
        Supplier supplier = supplierService.findById(id);
        // 3. 把图书信息显示到页面中
        req.setAttribute("supplier",supplier);
        req.getRequestDispatcher("/providerView.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
