package cn.gjp0609.web.user_management.v2.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 有关连接数据库工具类
 *
 * @author gjp06
 */
public class Jdbc {
    private static final Properties prop = new Properties();
    private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    private static final ThreadLocal<PreparedStatement> tl2 = new ThreadLocal<PreparedStatement>();

    static {
        // 获取流
        InputStream is = Jdbc.class.getResourceAsStream("/files/prop.properties");
        try {
            // 读取配置文件
            prop.load(is);
            String driver = prop.getProperty("driver");
            // 加载Oracle驱动类
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从ThreadLocal中获取当前线程的Connection对象，若无则创建一个新的对象
     *
     * @return 返回conn对象
     */
    public static Connection getConnection() {
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        // 从tl中获取当前线程的Connection对象
        Connection conn = tl.get();
        if (conn == null)
            try {
                conn = DriverManager.getConnection(url, username, password);
                tl.set(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return conn;
    }

    /**
     * 释放资源
     *
     * @param conn Connection
     * @param ps   PreparedStatement
     * @param rs   ResultSet
     */
    public static void release(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
