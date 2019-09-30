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
 * 供应商所有数据信息
 *
 * @author xu
 * @date 26/9/2019 上午10:35
 */
@WebServlet("/supplierlist")
public class SupplierListServlet extends HttpServlet {

    private SupplierService supplierService = new SupplierServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取所有的供应商
        List<Supplier> list = supplierService.getAll();
        // 2.把供应商列表存入到request域中,方便在页面通过jstl和el获取
        req.setAttribute("list", list);
        //重定向到jsp页面并显示
        req.getRequestDispatcher("/providerList.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
