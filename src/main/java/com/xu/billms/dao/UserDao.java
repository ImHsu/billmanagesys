package com.xu.billms.dao;

import com.xu.billms.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 用户操作层
 * 操作数据库
 * @author xu
 * @date 25/9/2019 下午11:22
 */
public interface UserDao {
    /**
     * 登录的时候调用
     * 根据用户名,密码查找
     *
     * @param username 用户名
     * @param password 密码
     * @return 成功返回对应对象,失败返回null
     */
    User selectByUsernameAndPassword(String username, String password);

    /**
     * 查找并得到所有用户
     * @return 所有用户数据
     */
    List<User> selectAll();

    /**
     * 更加参数更新数据
     *
     * @param parameterMap 需要更新的数据
     */
    void update(Map<String, String[]> parameterMap);

    /**
     * 根据id返回用户
     *
     * @param id 用户id
     * @return 返回对应id的用户对象
     */
    User selectById(String id);

    /**
     * 更加id删除用户
     *
     * @param id 用户id
     */
    void deleteById(String id);

    /**
     * 保存用户,添加的时候调用
     *
     * @param params 需要保存的用用户的数据
     * @param pwd 加密后的密码
     * @return 成功返回1, 失败-1
     */
    int insertUser(Map<String, String[]> params, String pwd);

    /**
     * 根据用户名字查询用户
     *
     * @param name 用户名字
     * @return 返回用户列表
     */
    List<User> selectByName(String name);

    /**
     * 更新密码
     *
     * @param parameterMap 修改密码的参数
     * @param req          HttpServletRequest
     * @param resp         HttpServletResponse
     * @return 成功true, 失败false
     */
    boolean updatePwd(Map<String, String[]> parameterMap, HttpServletRequest req, HttpServletResponse resp);
}
