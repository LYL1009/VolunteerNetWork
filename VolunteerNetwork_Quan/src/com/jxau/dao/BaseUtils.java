package com.jxau.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseUtils {

    private static ComboPooledDataSource dataSource;

    static  {
        dataSource = new ComboPooledDataSource("MySQL");
    }

    /*static {
        try {
            // 创建数据源 工厂模式-->创建对象
            dataSource = new ComboPooledDataSource("MySQL"); // 配置文件写法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    // 获取连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection(); // 从数据源中获取连接
        } catch (SQLException e) {
        }
        return connection;
    }

    // 释放连接
    public static void release(Connection connection, PreparedStatement pst, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
