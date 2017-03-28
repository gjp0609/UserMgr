package cn.gjp0609.web.user_management.v2.action;

import cn.gjp0609.web.user_management.v2.entity.Admin;
import cn.gjp0609.web.user_management.v2.entity.User;
import cn.gjp0609.web.user_management.v2.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 更新用户信息
 * Created by gjp06 on 17.3.24.
 */
public class UserUpdateAction extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset:utf-8");
        resp.setCharacterEncoding("utf-8");
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        if (admin == null) resp.sendRedirect("/usermgr/adminLogin.html");

        else {
            String userid = req.getParameter("userid");
            User u = new UserServiceImpl().selectUserById(userid);
            req.setAttribute("user", u);
            req.getRequestDispatcher("/userUpdateJsp").forward(req, resp);
        }
    }
}
