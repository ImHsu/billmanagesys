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
 * 供应商修改前的编辑信息
 *
 * @author xu
 * @date 26/9/2019 下午8:14
 */
@WebServlet("/supplieredit")
public class SupplierEditServlet extends HttpServlet {

    private SupplierService supplierService = new SupplierServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取提交的参数
        String id = req.getParameter("id");
        // 2.根据ID获取修改的供应商信息
        Supplier supplier = supplierService.findById(id);
        // 3. 把供应商信息显示到页面中
        req.setAttribute("supplier",supplier);
        req.getRequestDispatcher("/providerUpdate.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
