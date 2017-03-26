package cn.gjp0609.web.user_management.v2.service.impl;

import cn.gjp0609.web.user_management.v2.dao.impl.AdminDaoImpl;
import cn.gjp0609.web.user_management.v2.dao.impl.UserDaoImpl;
import cn.gjp0609.web.user_management.v2.entity.Admin;
import cn.gjp0609.web.user_management.v2.entity.User;
import cn.gjp0609.web.user_management.v2.service.AdminService;

/**
 * Created by gjp06 on 17.3.24.
 */
public class AdminServiceImpl implements AdminService {
    @Override
    public Admin signin(String adminname, String password) {
        return new AdminDaoImpl().selectAdminByNameAndPwd(adminname, password);
    }


}
