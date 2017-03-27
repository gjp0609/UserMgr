package cn.gjp0609.web.user_management.v2.action;

import cn.gjp0609.web.user_management.v2.entity.User;
import cn.gjp0609.web.user_management.v2.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by gjp06 on 17.3.24.
 */
public class AdminSelectAllAction extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset:utf-8");
        List<User> users = new UserServiceImpl().selectAllUsers();
        req.setAttribute("users", users);

        req.getRequestDispatcher("test.jsp").forward(req, resp);
    }
}
