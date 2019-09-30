package com.xu.billms.service.impl;

import com.xu.billms.dao.BillDao;
import com.xu.billms.dao.impl.BillDaoImpl;
import com.xu.billms.entity.Bill;
import com.xu.billms.service.BillService;
import com.xu.billms.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author xu
 * @date 26/9/2019 上午11:18
 */
public class BillServiceImpl implements BillService {
    private BillDao billDao = new BillDaoImpl();

    @Override
    public List<Bill> getAll() { return billDao.selectAll(); }

    @Override
    public Bill findById(String id) {
        if (StringUtils.isNotEmpty(id)) {
            // 调用Dao方法,获取数据
            return billDao.selectById(id);
        }
        return null;
    }

    @Override
    public void update(Map<String, String[]> parameterMap) {
        billDao.update(parameterMap);
    }

    @Override
    public void deleteById(String id) {
        billDao.deleteById(id);
    }

    @Override
    public void save(Map<String, String[]> params) {
        billDao.insertBill(params);
    }

    @Override
    public List<Bill> selectByParams(Map<String, String[]> params) {
        return billDao.selectByParams(params);
    }
}