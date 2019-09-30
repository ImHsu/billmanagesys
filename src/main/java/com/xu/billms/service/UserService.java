package com.xu.billms.service;

import com.xu.billms.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 用户对应的一些业务
 *
 * @author xu
 * @date 26/9/2019 下午12:42
 */

public interface UserService {
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
    User findById(String id);

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
     * @return 成功返回1, 失败-1
     */
    int save(Map<String, String[]> params);

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
