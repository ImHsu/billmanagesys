package com.xu.billms.dao;

import com.xu.billms.entity.Bill;

import java.util.List;
import java.util.Map;

/**
 * 账单数据操作层
 *
 * @author xu
 * @date 26/9/2019 上午11:19
 */
public interface BillDao {
    /**
     * 得到所有账单数据
     * @return 账单集合
     */
    List<Bill> selectAll();

    /**
     * 根据id查找账单
     *
     * @param id 账单id
     * @return 账单对象
     */
    Bill selectById(String id);

    /**
     * 跟新账单数据
     *
     * @param parameterMap 需要跟新的数据信息
     */
    void update(Map<String, String[]> parameterMap);

    /**
     * 根据账单id删除
     *
     * @param id 账单id
     */
    void deleteById(String id);

    /**
     * 添加账单
     *
     * @param params 添加的参数
     */
    void insertBill(Map<String, String[]> params);

    /**
     * 模糊查询,根据账单参数查数据
     *
     * @param params 参数
     * @return 返回查询的数据
     */
    List<Bill> selectByParams(Map<String, String[]> params);
}
