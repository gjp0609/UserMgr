package cn.gjp0609.web.user_management.v2.dao;

import cn.gjp0609.web.user_management.v2.entity.Admin;

public interface AdminDao {
    /**
     * 通过用户名和密码查找管理员用户
     *
     * @return
     */
    public Admin selectAdminByNameAndPwd(String adminname, String password);
}
