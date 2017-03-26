package cn.gjp0609.web.user_management.v2.utils;

import java.sql.Connection;

/**
 * 事务控制
 * Created by gjp06 on 17.3.24.
 */
public class TransactionManager {
    /**
     * 开启事务
     */
    public static void begin() {
        Connection conn = null;
        try {
            conn = Jdbc.getConnection();
            conn.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public static void commit() {
        Connection conn = null;
        try {
            conn = Jdbc.getConnection();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Jdbc.release(conn, null, null);
        }
    }

    /**
     * 回滚事务
     */
    public static void rollback() {
        Connection conn = null;
        try {
            conn = Jdbc.getConnection();
            conn.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Jdbc.release(conn, null, null);
        }
    }
}
