package cn.gjp0609.web.user_management.v2.service;

import cn.gjp0609.web.user_management.v2.entity.User;

import java.util.List;

/**
 * us
 * Created by gjp06 on 17.3.24.
 */
public interface UserService {
    public User signin(String username, String password);

    public int deleteUser(String id);

    public List<User> selectAllUsers();

    public int updateUser(User user);

    public int signup(User user);
    public User selectUserById(String id);
}
