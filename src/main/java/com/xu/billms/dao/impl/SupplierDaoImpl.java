package com.xu.billms.dao.impl;

import com.xu.billms.dao.SupplierDao;
import com.xu.billms.entity.Supplier;
import com.xu.billms.entity.User;
import com.xu.billms.util.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @author xu
 * @date 26/9/2019 上午10:44
 */
public class SupplierDaoImpl implements SupplierDao {
    @Override
    public List<Supplier> selectAll() {
        String sql = "select * from supplier";
        // 2.执行SQL
        return JDBCUtils.executeQuery(Supplier.class, sql);
    }

    @Override
    public void update(Map<String, String[]> parameterMap) {
        String sql = "update supplier set " +
                "name = ?, " +
                "contact = ?, " +
                "phone = ? , " +
                "fax = ?, " +
                "date = ? where id = ?";
        JDBCUtils.executeUpdate(sql,
                parameterMap.get("name")[0],
                parameterMap.get("contact")[0],
                parameterMap.get("phone")[0],
                parameterMap.get("fax")[0],
                parameterMap.get("date")[0],
                parameterMap.get("id")[0]
        );
    }

    @Override
    public Supplier selectById(String id) {
        String sql = "select * from supplier where id = ?";
        return JDBCUtils.executeQueryForOne(Supplier.class, sql, id);
    }

    @Override
    public void deleteById(String id) {
        String sql = "delete from supplier where id = ?";
        JDBCUtils.executeUpdate(sql, id);
    }

    @Override
    public void insertUser(Map<String, String[]> params) {
        String sql = "insert into supplier(name,contact,phone,fax,date) values(?,?,?,?,?)";
        JDBCUtils.executeUpdate(sql,
                params.get("name")[0],
                params.get("contact")[0],
                params.get("phone")[0],
                params.get("fax")[0],
                params.get("date")[0]);
    }

    @Override
    public List<Supplier> selectByIdlist(Integer id) {
        String sql = "select * from supplier where id=? ";
        return JDBCUtils.executeQuery(Supplier.class, sql,id);
    }
}
