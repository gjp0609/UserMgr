package cn.gjp0609.web.user_management.v2.u_tests;

import cn.gjp0609.web.user_management.v2.dao.UserDao;
import cn.gjp0609.web.user_management.v2.dao.impl.UserDaoImpl;
import cn.gjp0609.web.user_management.v2.entity.User;
import cn.gjp0609.web.user_management.v2.utils.Jdbc;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

/**
 * Created by gjp06 on 17.3.24.
 */
class TestUserDao {
    @Test
    void testSelectUserByNameAndPwd() {
        UserDao ud = new UserDaoImpl();
        User user = ud.selectUserByNameAndPwd("zhangSan", "123456");
        System.out.println(user);
    }

    @Test
    void testSelectAllUsers() {
        UserDao ud = new UserDaoImpl();
        List<User> users = ud.selectAllUsers();
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    void testInsertUser() {
        UserDao ud = new UserDaoImpl();
        User user = new User(null, "pingzi",
                "123456", 18, "123@123.123", "北京");
        System.out.println(ud.insertUser(user));
    }

    @Test
    void testD() {
        UserDao ud = new UserDaoImpl();
        System.out.println(ud.deleteUserById("126"));
        Connection conn= Jdbc.getConnection();
    }


}
