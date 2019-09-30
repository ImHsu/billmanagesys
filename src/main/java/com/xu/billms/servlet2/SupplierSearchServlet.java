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
import java.util.List;

/**
 * 供应商搜索
 *
 * @author xu
 * @date 27/9/2019 上午9:55
 */
@WebServlet("/suppliersearch")
public class SupplierSearchServlet extends HttpServlet {
    private SupplierService supplierService = new SupplierServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //String name = req.getParameter("id");
        Integer id = Integer.valueOf(req.getParameter("id"));
        System.out.println(id);
        List<Supplier> list = supplierService.selectById(id);
        System.out.println(list);
        req.setAttribute("list", list);
        req.getRequestDispatcher("/providerList.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
