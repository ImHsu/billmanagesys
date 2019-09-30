package com.xu.billms.service.impl;

import com.xu.billms.dao.SupplierDao;
import com.xu.billms.dao.impl.SupplierDaoImpl;
import com.xu.billms.entity.Supplier;
import com.xu.billms.service.SupplierService;
import com.xu.billms.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author xu
 * @date 26/9/2019 上午10:41
 */
public class SupplierServiceImpl implements SupplierService {

    private SupplierDao supplierDao = new SupplierDaoImpl();

    @Override
    public void save(Map<String, String[]> params) {
        supplierDao.insertUser(params);
    }

    @Override
    public List<Supplier> getAll() {
        return supplierDao.selectAll();
    }

    @Override
    public void update(Map<String, String[]> parameterMap) {
        supplierDao.update(parameterMap);
    }

    @Override
    public Supplier findById(String id) {
        if (StringUtils.isNotEmpty(id)) {
            // 调用Dao方法,获取数据
            return supplierDao.selectById(id);
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        supplierDao.deleteById(id);
    }

    @Override
    public List<Supplier> selectById(Integer id) {

        return supplierDao.selectByIdlist(id);
    }
}
