package cn.gjp0609.web.user_management.v2.dao;

import java.util.List;

import cn.gjp0609.web.user_management.v2.entity.User;

public interface UserDao {
    /**
     * 通过用户名和密码查找用户
     *
     * @return
     */
    public User selectUserByNameAndPwd(String username, String password);

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<User> selectAllUsers();

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    public int insertUser(User user);

    /**
     * 通过ID删除用户
     *
     * @param id
     * @return
     */
    public int deleteUserById(String id);

    public int updateUser(User user);

    public User selectUserById(String id);
}
