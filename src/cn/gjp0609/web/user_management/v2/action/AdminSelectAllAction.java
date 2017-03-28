package cn.gjp0609.web.user_management.v2.action;

import cn.gjp0609.web.user_management.v2.entity.Admin;
import cn.gjp0609.web.user_management.v2.entity.User;
import cn.gjp0609.web.user_management.v2.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 调用 UserServiceImpl 查询所有用户信息
 * 转发到 selectAllUsersJsp
 * - test - 转发到 test.jsp
 * Created by gjp06 on 17.3.24.
 */
public class AdminSelectAllAction extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 控制文本格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset:utf-8");

        // 判断管理员是否已登陆
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        if (admin == null) resp.sendRedirect("/usermgr/adminLogin.html");
//        req.getRequestDispatcher("test.jsp").forward(req, resp);
        else {
            List<User> users = new UserServiceImpl().selectAllUsers();
            req.setAttribute("users", users);
            req.getRequestDispatcher("/selectAllUsersJsp").forward(req, resp);
        }
    }
}
