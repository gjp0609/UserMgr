package cn.gjp0609.web.user_management.v2.action;

import cn.gjp0609.web.user_management.v2.entity.User;
import cn.gjp0609.web.user_management.v2.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录
 * 成功则重定向到 loginSuss.html
 * 失败则重定向到 loginFaild.html
 * Created by gjp06 on 17.3.24.
 */
public class UserLoginAction extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // 获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new UserServiceImpl().signin(username, password);
        if (user == null)
            resp.sendRedirect("loginFaild.html");
        else resp.sendRedirect("loginSuss.html");
    }
}
