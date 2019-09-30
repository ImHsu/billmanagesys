package com.xu.billms.service.impl;

import com.xu.billms.dao.UserDao;
import com.xu.billms.dao.impl.UserDaoImpl;
import com.xu.billms.entity.User;
import com.xu.billms.service.UserService;
import com.xu.billms.util.EncryptUtils;
import com.xu.billms.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author xu
 * @date 26/9/2019 下午12:44
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void update(Map<String, String[]> parameterMap) {
        userDao.update(parameterMap);
    }

    @Override
    public User findById(String id) {
        if (StringUtils.isNotEmpty(id)) {
            // 调用Dao方法,获取数据
            return userDao.selectById(id);
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        userDao.deleteById(id);
    }

    @Override
    public int save(Map<String, String[]> params) {
        String pwd = EncryptUtils.getPwd(params.get("username")[0] + params.get("password")[0]);
        return userDao.insertUser(params,pwd);
    }

    @Override
    public List<User> selectByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public boolean updatePwd(Map<String, String[]> parameterMap, HttpServletRequest req, HttpServletResponse resp) {
        return userDao.updatePwd(parameterMap,req,resp);
    }

}
