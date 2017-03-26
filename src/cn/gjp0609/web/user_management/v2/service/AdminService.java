package cn.gjp0609.web.user_management.v2.service;

import cn.gjp0609.web.user_management.v2.entity.Admin;
import cn.gjp0609.web.user_management.v2.entity.User;

/**
 * Created by gjp06 on 17.3.24.
 */
public interface AdminService {
    public Admin signin(String adminname, String password);

}
