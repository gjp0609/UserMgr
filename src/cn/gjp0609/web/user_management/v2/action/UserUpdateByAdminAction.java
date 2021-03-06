package cn.gjp0609.web.user_management.v2.action;

import cn.gjp0609.web.user_management.v2.entity.Admin;
import cn.gjp0609.web.user_management.v2.entity.User;
import cn.gjp0609.web.user_management.v2.service.UserService;
import cn.gjp0609.web.user_management.v2.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * admin 管理用户信息
 * Created by gjp06 on 17.3.26.
 */
public class UserUpdateByAdminAction extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset:utf-8");
        resp.setCharacterEncoding("utf-8");

        Admin admin = (Admin) req.getSession().getAttribute("admin");
        if (admin == null) resp.sendRedirect("/usermgr/adminLogin.html");
        else {
            String id = req.getParameter("id");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            Integer age = Integer.valueOf(req.getParameter("age"));
            String email = req.getParameter("email");
            String address = req.getParameter("address");

            User u = new User(id, username, password, age, email, address);
            UserService us = new UserServiceImpl();
            int k = us.updateUser(u);
            if (k == 0) {
                PrintWriter pw = resp.getWriter();
                pw.println("修改失败");
                pw.close();
            } else {
                // 修改成功，返回查询界面
                resp.sendRedirect("/usermgr/adminSelectAllAction");
            }
        }
    }
}
