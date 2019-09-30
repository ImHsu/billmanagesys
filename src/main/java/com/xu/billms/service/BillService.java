package com.xu.billms.service;

import com.xu.billms.entity.Bill;
import com.xu.billms.entity.Supplier;

import java.util.List;
import java.util.Map;

/**
 * @author xu
 * @date 26/9/2019 上午11:17
 */
public interface BillService {
    /**
     * 得到所有账单数据
     *
     * @return 账单集合
     */
    List<Bill> getAll();

    /**
     * 根据id查找账单
     *
     * @param id 账单id
     * @return 账单对象
     */
    Bill findById(String id);

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
     * 保存账单
     *
     * @param params 保存的参数
     */
    void save(Map<String, String[]> params);

    /**
     * 模糊查询,根据账单参数查数据
     *
     * @param params 参数
     * @return 返回查询的数据
     */
    List<Bill> selectByParams(Map<String, String[]> params);
}