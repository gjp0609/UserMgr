package cn.gjp0609.web.user_management.v2.action;

import cn.gjp0609.web.user_management.v2.entity.Admin;
import cn.gjp0609.web.user_management.v2.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户删除
 * 根据传入用户 id 进行删除用户操作
 * 删除后重定向到 adminSelectAllAction
 * Created by gjp06 on 17.3.26.
 */
public class UserDeleteAction extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset:utf-8");
        resp.setCharacterEncoding("utf-8");

        // 判断管理员是否已登陆
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        if (admin != null) {
            String userid = req.getParameter("userid");
            new UserServiceImpl().deleteUser(userid);
            resp.sendRedirect("/usermgr/adminSelectAllAction");
        } else resp.sendRedirect("/usermgr/adminLogin.html");
    }
}
