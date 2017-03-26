package cn.gjp0609.web.user_management.v2.dao.impl;

import cn.gjp0609.web.user_management.v2.dao.AdminDao;
import cn.gjp0609.web.user_management.v2.entity.Admin;
import cn.gjp0609.web.user_management.v2.utils.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * daoimpl
 * Created by gjp06 on 17.3.24.
 */
public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin selectAdminByNameAndPwd(String adminname, String password) {
        Connection conn = Jdbc.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Admin admin = null;
        String sql = "SELECT * FROM T_ADMIN_V2 WHERE ADMINNAME=? AND PASSWORD=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, adminname);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                admin = new Admin();
                admin.setAdminname(rs.getString("adminname"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.release(null, ps, rs);
        }
        return admin;
    }
}
