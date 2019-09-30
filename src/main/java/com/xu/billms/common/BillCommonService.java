package com.xu.billms.common;

import com.xu.billms.util.StringUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ${Description}
 *
 * @author xu
 * @date 28/9/2019 上午3:28
 */
public abstract class BillCommonService extends HttpServlet{
    private static final String METHOD_KEY = "method";
    private static final String PATH_PREFIX = "redirect:";
    private static final String VIEW_SUFFIX = ".jsp";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行具体的操作");
        // 1.获取请求的参数
        String method = req.getParameter(METHOD_KEY);
        // 2.判读方法是否在
        if (StringUtils.isNotEmpty(method)) {
            // 3.使用工具类把add转换成doAdd
            //String doMethod = StringUtils.appendDoMethod(METHOD_PREFIX, method);
            // 4.获取当前类的类类型
            Class<?> aClass = this.getClass();
            try {
                // 5.通过反射获取方法
                Method method1 = aClass.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
                // 6.调用方法
                Object result = method1.invoke(this, req, resp);
                // 7.判断返回值的类型是否是String
                if (result instanceof String) {
                    String path = (String) result;
                    if (StringUtils.isNotEmpty(path)) {
                        // 判断路径是否以 redirect:开头,如果是,则调用重定向方法
                        if (path.startsWith(PATH_PREFIX)) {
                            // 截取
                            String substring = path.substring(PATH_PREFIX.length());
                            // 重定向
                            resp.sendRedirect(req.getContextPath() + substring);
                        } else {
                            // 请求转发
                            req.getRequestDispatcher(path + VIEW_SUFFIX).forward(req, resp);
                        }
                    }
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        }


    }
}
