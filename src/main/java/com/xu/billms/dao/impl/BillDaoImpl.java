package com.xu.billms.dao.impl;

import com.xu.billms.dao.BillDao;
import com.xu.billms.entity.Bill;
import com.xu.billms.util.JDBCUtils;
import com.xu.billms.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 实现类
 *
 * @author xu
 * @date 26/9/2019 上午11:19
 */
public class BillDaoImpl implements BillDao {
    @Override
    public List<Bill> selectAll() {
        String sql = "select * from bill";
        return JDBCUtils.executeQuery(Bill.class, sql);
    }

    @Override
    public Bill selectById(String id) {
        String sql = "select * from bill where id = ?";
        return JDBCUtils.executeQueryForOne(Bill.class, sql, id);
    }

    @Override
    public void update(Map<String, String[]> parameterMap) {
        String sql = "update bill set " +
                "product = ?, " +
                "supplier = ?, " +
                "amount = ? , " +
                "pay = ?, " +
                "date = ? where id = ?";

        JDBCUtils.executeUpdate(sql,
                parameterMap.get("product")[0],
                parameterMap.get("supplier")[0],
                parameterMap.get("amount")[0],
                parameterMap.get("pay")[0],
                parameterMap.get("date")[0],
                parameterMap.get("id")[0]);
    }

    @Override
    public void deleteById(String id) {
        String sql = "delete from bill where id = ?";
        JDBCUtils.executeUpdate(sql, id);
    }

    @Override
    public void insertBill(Map<String, String[]> params) {
        String sql = "insert into bill(product,supplier,amount,pay,date) values(?,?,?,?,?)";
        JDBCUtils.executeUpdate(sql,
                params.get("product")[0],
                params.get("supplier")[0],
                params.get("amount")[0],
                params.get("pay")[0],
                params.get("date")[0]);
    }
    @Override
    public List<Bill> selectByParams(Map<String, String[]> params) {
        // 根据条件拼接sql
        StringBuffer sql = new StringBuffer("select * from bill where 1 = 1");
        List<Object> parmsSql = new ArrayList<>();
        if (params.get("product") != null && StringUtils.isNotEmpty(params.get("product")[0])) {
            sql.append(" and product like ?");
            parmsSql.add("%"+params.get("product")[0]+"%");
        }
        if (params.get("supplier") != null && StringUtils.isNotEmpty(params.get("supplier")[0])) {
            sql.append(" and supplier like ?");
            parmsSql.add("%"+params.get("supplier")[0]+"%");
        }
        if (params.get("amount") != null && StringUtils.isNotEmpty(params.get("amount")[0])) {
            sql.append(" and amount like ?");
            parmsSql.add("%"+params.get("amount")[0]+"%");
        }
        System.out.println("拼接好的sql语句:"+sql.toString());
        System.out.println(parmsSql);
        List<Bill> bills = JDBCUtils.executeQuery(Bill.class, sql.toString(), parmsSql);
        System.out.println("bills"+bills);
        return bills;
    }
}
