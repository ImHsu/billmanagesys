package com.xu.billms.servlet3;

import com.xu.billms.common.BillCommonService;
import com.xu.billms.entity.Bill;
import com.xu.billms.service.BillService;
import com.xu.billms.service.impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 关于账单进一步的封装类继承与BillCommonService
 *
 * @author xu
 * @date 28/9/2019 下午3:20
 */
@WebServlet("/bills")
public class BillsServlet extends BillCommonService {

    private BillService billService = new BillServiceImpl();

    public String List(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取所有的图书
        List<Bill> list = billService.getAll();
        // 2.把图书列表存入到request域中,方便在页面通过jstl和el获取
        req.setAttribute("list", list);
        //req.getRequestDispatcher("/billList.jsp").forward(req,resp);
        return "billList";
    }

    public String Add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Map<String, String[]> params = req.getParameterMap();
        billService.save(params);
        //resp.sendRedirect(req.getContextPath()+"/billlist");
        return "redirect:/bills?method=List";
    }


    public String Search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 获取所有的参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 调用方法
        List<Bill> list = billService.selectByParams(parameterMap);
        req.setAttribute("list", list);
        // 返回列表
        //req.getRequestDispatcher("/billList.jsp").forward(req,resp);
        return "billList";
    }

    public String Update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 获取所有的参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 调用方法
        billService.update(parameterMap);
        // 返回列表
        //resp.sendRedirect(req.getContextPath()+"/billlist");
        return "redirect:/bills?method=List";
    }
}
