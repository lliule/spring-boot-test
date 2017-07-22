package com.lly;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class TestConn {

    @Test
    public void test1() throws ClassNotFoundException, SQLException {
        String driverName="oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
        String user = "boot1";
        String password = "boot";
        Class.forName(driverName);

        //获取数据库连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);


        List<Integer> list = Arrays.asList(1, 2, 3);

        Collections.sort(list);
    }



}
