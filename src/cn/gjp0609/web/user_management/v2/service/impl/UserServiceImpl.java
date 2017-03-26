package cn.gjp0609.web.user_management.v2.service.impl;

import cn.gjp0609.web.user_management.v2.dao.UserDao;
import cn.gjp0609.web.user_management.v2.dao.impl.UserDaoImpl;
import cn.gjp0609.web.user_management.v2.entity.User;
import cn.gjp0609.web.user_management.v2.service.UserService;
import cn.gjp0609.web.user_management.v2.utils.Jdbc;
import cn.gjp0609.web.user_management.v2.utils.TransactionManager;

import java.sql.Connection;
import java.util.List;

/**
 * impl
 * Created by gjp06 on 17.3.24.
 */
public class UserServiceImpl implements UserService {
    private UserDao ud = new UserDaoImpl();

    @Override
    public User signin(String username, String password) {
        return ud.selectUserByNameAndPwd(username, password);
    }

    @Override
    public List<User> selectAllUsers() {
        return ud.selectAllUsers();
    }

    @Override
    public int deleteUser(String id) {
        Connection conn = Jdbc.getConnection();
        int r = 0;
        try {
            TransactionManager.begin();
            r = ud.deleteUserById(id);
            if (r != 1) throw new RuntimeException("不存在 "+r);
            TransactionManager.commit();
        } catch (Exception e) {
            TransactionManager.rollback();
            e.printStackTrace();
        } finally {
            Jdbc.release(conn, null, null);
        }
        return r;
    }

    @Override
    public int updateUser(User user) {
        Connection conn = Jdbc.getConnection();
        int k = 0;
        try {
            TransactionManager.begin();
            if (user == null) throw new RuntimeException("user null");
            k = ud.updateUser(user);
            if (k != 1) throw new RuntimeException("更新失败");
            TransactionManager.commit();
        } catch (Exception e) {
            TransactionManager.rollback();
            e.printStackTrace();
        } finally {
            Jdbc.release(conn, null, null);
        }
        return k;
    }

    @Override
    public int signup(User user) {
        Connection conn = Jdbc.getConnection();
        int k = 0;
        try {
            TransactionManager.begin();
            if (user == null) throw new RuntimeException("user null");
            k = ud.insertUser(user);
            if (k != 1) throw new RuntimeException("插入失败");
            TransactionManager.commit();
        } catch (Exception e) {
            TransactionManager.rollback();
            e.printStackTrace();
        } finally {
            Jdbc.release(conn, null, null);
        }
        return k;
    }

    @Override
    public User selectUserById(String id) {
        return new UserDaoImpl().selectUserById(id);
    }
}
