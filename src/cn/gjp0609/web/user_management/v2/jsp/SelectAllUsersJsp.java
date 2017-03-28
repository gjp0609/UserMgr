package cn.gjp0609.web.user_management.v2.jsp;

import cn.gjp0609.web.user_management.v2.entity.Admin;
import cn.gjp0609.web.user_management.v2.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by gjp06 on 17.3.24.
 */
public class SelectAllUsersJsp extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset:utf-8");

        Admin admin = (Admin) req.getSession().getAttribute("admin");
        if (admin == null) resp.sendRedirect("/usermgr/adminLogin.html");

        else {
            List<User> users = (List<User>) req.getAttribute("users");
            PrintWriter pw = resp.getWriter();
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<meta charset='utf-8' />");
            pw.println("<style>td {padding: 5px;text-align:center;}</style>");
            pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"sty.css\"/>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<table border='solid red 1px' cellspacing=0>");
            pw.println("<tr>");
            pw.println("<th>id</th><th>name</th><th>password</th><th>age</th>" +
                    "<th>email</th><th>address</th><th></th><th></th>");
            pw.println("</tr>");
            for (User u : users) {
                pw.println("<tr>");
                pw.println("<td>" + u.getId() + "</td>");
                pw.println("<td>" + u.getUsername() + "</td>");
                pw.println("<td>" + u.getPassword() + "</td>");
                pw.println("<td>" + u.getAge() + "</td>");
                pw.println("<td>" + u.getEmail() + "</td>");
                pw.println("<td>" + u.getAddress() + "</td>");
                pw.println("<td><a href='/usermgr/userUpdateAction?userid=" + u.getId() + "'>Edit</a></td>");
                pw.println("<td><a href='/usermgr/userDeleteAction?userid=" + u.getId() + "'>Delete</a></td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</body>");
            pw.println("</html>");
            pw.close();

        }

    }
}
