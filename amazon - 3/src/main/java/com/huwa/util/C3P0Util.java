package com.huwa.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Util {
    //读取配置文件并创建一个连接池对象(数据源)
    private static DataSource ds = new ComboPooledDataSource();

    public static DataSource getDs() {
        return ds;
    }

    public static Connection getConnection() {

        try {
            return getDs().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


