package cn.gjp0609.web.user_management.v2.action;

import cn.gjp0609.web.user_management.v2.entity.User;
import cn.gjp0609.web.user_management.v2.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gjp06 on 17.3.26.
 */
public class UserDeleteAction extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset:utf-8");
        resp.setCharacterEncoding("utf-8");
        String userid = req.getParameter("userid");
        int k = new UserServiceImpl().deleteUser(userid);
        resp.sendRedirect("/usermgr/adminSelectAllAction");
    }
}
