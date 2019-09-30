package com.xu.billms.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xu
 * @date 28/9/2019 下午4:58
 */
public class EncryptUtilsTest {

    @Test
    public void getPwd() {
        String pwd = EncryptUtils.getPwd("qqwe");
        System.out.println(pwd);

    }
}