package cn.gjp0609.web.user_management.v2.action;

import cn.gjp0609.web.user_management.v2.entity.Admin;
import cn.gjp0609.web.user_management.v2.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gjp06 on 17.3.24.
 */
public class AdminLoginAction extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String adminname = req.getParameter("adminname");
        String password = req.getParameter("password");
        Admin admin = new AdminServiceImpl().signin(adminname, password);
        if (admin == null) resp.sendRedirect("loginFaild.html");
        else req.getRequestDispatcher("/adminSelectAllAction").forward(req, resp);
    }
}
