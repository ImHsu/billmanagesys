package com.xu.billms.service.impl;

import com.xu.billms.dao.UserDao;
import com.xu.billms.dao.impl.UserDaoImpl;
import com.xu.billms.entity.User;
import com.xu.billms.service.LoginService;
import com.xu.billms.util.EncryptUtils;
import com.xu.billms.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author xu
 * @date 25/9/2019 下午11:16
 */
public class LoginServiceImpl implements LoginService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean login(String username, String password, String remember, HttpServletRequest request, HttpServletResponse response) {
        // 判断用户名和密码是否存在
        if (StringUtils.isNotEmpty(username)&&StringUtils.isNotEmpty(password)){
            // TODO 查询数据库,是否有该用户
            User user = userDao.selectByUsernameAndPassword(username, EncryptUtils.getPwd(username + password));
            System.out.println("加密:"+EncryptUtils.getPwd(username + password));
            return user != null;
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return userDao.selectAll();
    }
}
