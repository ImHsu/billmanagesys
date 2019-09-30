package com.xu.billms.servlet2;

import com.xu.billms.service.SupplierService;
import com.xu.billms.service.impl.SupplierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 添加供应商
 *
 * @author xu
 * @date 27/9/2019 上午9:36
 */
@WebServlet("/supplieradd")
public class SupplierAddServlet extends HttpServlet {
    private SupplierService supplierService = new SupplierServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Map<String, String[]> params = req.getParameterMap();
        supplierService.save(params);
        resp.sendRedirect(req.getContextPath()+"/supplierlist");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
