package cn.gjp0609.web.user_management.v2.action;

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
 * Created by gjp06 on 17.3.24.
 */
public class UserSignupAction extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset:utf-8");
        resp.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Integer age = Integer.valueOf(req.getParameter("age"));
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        User u = new User(null, username, password, age, email, address);
        UserService us = new UserServiceImpl();
        int k = us.signup(u);
        if (k == 0) {
            PrintWriter pw = resp.getWriter();
            pw.println("注册失败");
            pw.close();
        } else {
            req.setAttribute("user", u);
            req.getRequestDispatcher("/userSignupJsp").forward(req, resp);
        }
    }
}
