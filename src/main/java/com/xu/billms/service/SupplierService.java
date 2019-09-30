package com.xu.billms.service;

import com.xu.billms.entity.Supplier;

import java.util.List;
import java.util.Map;

/**
 * 供应商相关业务
 *
 * @author xu
 * @date 26/9/2019 上午10:41
 */
public interface SupplierService {

    /**
     * 保存供应商的数据
     * @param params 需要修改的数据
     */
    void save(Map<String, String[]> params);

    /**
     * 拿到所有的供应商数据
     * @return 供应商集合
     */
    List<Supplier> getAll();

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
    Supplier findById(String id);

    /**
     * 删除对应id的供应商
     * @param id 供应商id
     */
    void deleteById(String id);

    /**
     * 查找对应id供应商
     * @param id 供应商id
     * @return 供应商集合
     */
    List<Supplier> selectById(Integer id);
}
