package com.xu.billms.dao;

import com.xu.billms.entity.Supplier;

import java.util.List;
import java.util.Map;

/**
 * @author xu
 * @date 26/9/2019 上午10:43
 */
public interface SupplierDao {
    /**
     * 拿到所有的供应商数据
     * @return 供应商集合
     */
    List<Supplier> selectAll();

    /**
     * 跟新供应商信息
     *
     * @param parameterMap 需要更新的数据
     */
    void update(Map<String, String[]> parameterMap);

    /**
     * 查找对应id的供应商
     * @param id 供应商id
     * @return 返回Supplier对象
     */
    Supplier selectById(String id);

    /**
     * 删除对应id的供应商
     * @param id 供应商id
     */
    void deleteById(String id);

    /**
     * 添加供应商数据
     * @param params 添加的供应商数据
     */
    void insertUser(Map<String, String[]> params);

    /**
     * 根据id返回供应商集合
     * @param id 供应商id
     * @return 供应商结合
     */
    List<Supplier> selectByIdlist(Integer id);
}
