package cn.gjp0609.web.user_management.v2.jsp;

import cn.gjp0609.web.user_management.v2.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by gjp06 on 17.3.24.
 */
public class UserSignupJsp extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset:utf-8");
        User user = (User) req.getAttribute("user");
        PrintWriter pw = resp.getWriter();
        pw.println(user);

    }
}
