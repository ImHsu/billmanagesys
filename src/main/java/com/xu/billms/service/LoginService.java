package com.xu.billms.service;

import com.xu.billms.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author xu
 * @date 25/9/2019 下午11:15
 */
public interface LoginService {
    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @param remember 记住我
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return 登录成功返回true
     */
    boolean login(String username, String password, String remember, HttpServletRequest request, HttpServletResponse response);

    /**
     * 得到所有用户信息
     * @return 返回所有用户信息集合
     */
    List<User> getAll();
}
