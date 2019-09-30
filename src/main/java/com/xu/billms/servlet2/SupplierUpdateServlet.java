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
 * 跟新供应商信息数据
 *
 * @author xu
 * @date 26/9/2019 下午7:56
 */
@WebServlet("/supplierupdate")
public class SupplierUpdateServlet extends HttpServlet {

    private SupplierService supplierService = new SupplierServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 获取所有的参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 调用方法
        supplierService.update(parameterMap);
        // 重定向
        resp.sendRedirect(req.getContextPath()+"/supplierlist");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
