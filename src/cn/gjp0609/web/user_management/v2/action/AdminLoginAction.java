package cn.gjp0609.web.user_management.v2.action;

import cn.gjp0609.web.user_management.v2.entity.Admin;
import cn.gjp0609.web.user_management.v2.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 管理员登录
 * 判断管理员是否成功登陆
 * 成功登陆重定向到 loginFaild.html
 * 失败则转发到 adminSelectAllAction
 * Created by gjp06 on 17.3.24.
 */
public class AdminLoginAction extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 获取参数
        String adminname = req.getParameter("adminname");
        String password = req.getParameter("password");
        char[] chs = (char[]) req.getSession().getAttribute("vcode");

        // 判断得到的数组是否为空
        String vcode = chs == null ? "" : new String(chs);

        if (!vcode.isEmpty() && vcode.equalsIgnoreCase(req.getParameter("vcode"))) {
            req.getSession().removeAttribute("vcode");

            Admin admin = new AdminServiceImpl().signin(adminname, password);

            // 判断管理员是否登陆成功
            if (admin == null) resp.sendRedirect("adminLogin.html");
            else {
                // 在 Session 中存储成功登陆的 admin 对象
                req.getSession().setAttribute("admin", admin);
                req.getRequestDispatcher("/adminSelectAllAction").forward(req, resp);
            }
        } else resp.sendRedirect("adminLogin.html");

    }
}
