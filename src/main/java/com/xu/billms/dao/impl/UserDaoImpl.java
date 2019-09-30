package com.xu.billms.dao.impl;

import com.xu.billms.dao.UserDao;
import com.xu.billms.entity.User;
import com.xu.billms.util.EncryptUtils;
import com.xu.billms.util.JDBCUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * UserDao实现类
 *
 * @author xu
 * @date 25/9/2019 下午11:23
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User selectByUsernameAndPassword(String username, String password) {
        // 查询数据库
        // 1.定义sql语句
        String sql = "select * from user where username=? and password=?";
        // 2.执行
        return JDBCUtils.executeQueryForOne(User.class, sql, username, password);
    }

    @Override
    public List<User> selectAll() {
        String sql = "select * from user";
        // 2.执行SQL
        return JDBCUtils.executeQuery(User.class, sql);
    }

    @Override
    public void update(Map<String, String[]> parameterMap) {
        String sql = "update user set " +
                "name = ?, " +
                "sex = ?, " +
                "age = ?, " +
                "phone = ? , " +
                "city = ?, " +
                "userclass = ? where id = ?";
        JDBCUtils.executeUpdate(sql,
                parameterMap.get("name")[0],
                parameterMap.get("sex")[0],
                parameterMap.get("age")[0],
                parameterMap.get("phone")[0],
                parameterMap.get("city")[0],
                parameterMap.get("userclass")[0],
                parameterMap.get("id")[0]);

    }

    @Override
    public User selectById(String id) {

        String sql = "select * from user where id = ?";
        return JDBCUtils.executeQueryForOne(User.class, sql, id);
    }

    @Override
    public void deleteById(String id) {
        String sql = "delete from user where id = ?";
        JDBCUtils.executeUpdate(sql, id);
    }

    @Override
    public int insertUser(Map<String, String[]> params, String pwd) {
        String sql = "insert into user(username,password,name,sex,age,phone,city,userclass) values(?,?,?,?,?,?,?,?)";
        int i = JDBCUtils.executeUpdate(sql,
                params.get("username")[0],
                pwd,
                params.get("name")[0],
                params.get("sex")[0],
                params.get("age")[0],
                params.get("phone")[0],
                params.get("city")[0],
                params.get("userclass")[0]);
        return i;
    }

    @Override
    public List<User> selectByName(String name) {

        String sql = "select * from user where name=?";
        // 2.执行SQL
        return JDBCUtils.executeQuery(User.class, sql,name);
    }

    @Override
    public boolean updatePwd(Map<String, String[]> params, HttpServletRequest req, HttpServletResponse resp) {
        String UN= null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                //4.判断名称是否是USERNAME,USERNAME
                if ("USERNAME".equals(cookieName)) {
                    UN = cookie.getValue();
                }
            }
        }

        User user = selectByUsernameAndPassword(UN, EncryptUtils.getPwd(UN+req.getParameter("oldpassword")));

        if (user != null && req.getParameter("newpassword").equals(req.getParameter("renewpassword")) ) {
            String sql = "update user set " +
                    "password = ?" +
                    " where username = ?";
            JDBCUtils.executeUpdate(sql,EncryptUtils.getPwd(UN+req.getParameter("newpassword")), UN);
            return true;
        }
        return false;
    }


}
