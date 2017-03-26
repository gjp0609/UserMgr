package cn.gjp0609.web.user_management.v2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.gjp0609.web.user_management.v2.dao.UserDao;
import cn.gjp0609.web.user_management.v2.entity.User;
import cn.gjp0609.web.user_management.v2.utils.Jdbc;

public class UserDaoImpl implements UserDao {

    // 查询用户
    @Override
    public User selectUserByNameAndPwd(String username, String password) {
        Connection conn = Jdbc.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        String sql = "SELECT * FROM t_user_v2 WHERE username=? AND password=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.release(null, ps, rs);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        Connection conn = Jdbc.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM t_user_v2";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.release(null, ps, rs);
        }
        return users;
    }

    @Override
    public int insertUser(User user) {
        Connection conn = Jdbc.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int k = 0;
        String sql = "INSERT INTO T_USER_V2 VALUES (USER_V2_SEQ.nextval,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getAge());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getAddress());
            k = ps.executeUpdate();
            sql = "SELECT USER_V2_SEQ.currval FROM dual";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                String id = rs.getString(1);
                // 设置用户id
                user.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.release(null, ps, rs);
        }
        return k;
    }

    @Override
    public int deleteUserById(String id) {
        Connection conn = Jdbc.getConnection();
        PreparedStatement ps = null;
        int k = 0;
        String sql = "DELETE FROM T_USER_V2 WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            System.out.println(id+"------------");
            // todo
            k = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.release(null, ps, null);
        }
        return k;
    }

    @Override
    public int updateUser(User user) {
        Connection conn = Jdbc.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int k = 0;
        String sql = "UPDATE T_USER_V2 SET USERNAME=?, PASSWORD=?, AGE=?, EMAIL=?, ADDRESS=? WHERE ID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getAge());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getId());
            k = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.release(null, ps, rs);
        }
        return k;
    }

    @Override
    public User selectUserById(String id) {
        Connection conn = Jdbc.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        String sql = "SELECT * FROM t_user_v2 WHERE ID = " + id;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(id);
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.release(null, ps, rs);
        }
        return user;
    }

}
