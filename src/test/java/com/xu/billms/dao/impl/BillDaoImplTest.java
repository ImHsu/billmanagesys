package com.xu.billms.dao.impl;

import com.xu.billms.entity.Bill;
import com.xu.billms.util.JDBCUtils;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author xu
 * @date 28/9/2019 下午4:56
 */
public class BillDaoImplTest {


    @Test
    public void selectAll() {
        String sql = "select * from bill";
        List<Bill> bills = JDBCUtils.executeQuery(Bill.class, sql);
        System.out.println(bills);
    }

    @Test
    public void selectById() {
        int id = 3001;
        String sql = "select * from bill where id = ?";
        Bill bill = JDBCUtils.executeQueryForOne(Bill.class, sql, id);
        System.out.println(bill.getPay());
    }

    @Test
    public void update() {

    }

    @Test
    public void deleteById() {
    }

    @Test
    public void insertBill() {
    }

    @Test
    public void selectByParams() {
    }
}