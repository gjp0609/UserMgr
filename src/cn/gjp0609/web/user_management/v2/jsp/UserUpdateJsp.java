package cn.gjp0609.web.user_management.v2.jsp;

import cn.gjp0609.web.user_management.v2.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by gjp06 on 17.3.26.
 */
public class UserUpdateJsp extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset:utf-8");
        User u = (User) req.getAttribute("user");
        PrintWriter pw = resp.getWriter();
        pw.println(u);
        pw.println("<html lang='en'><head><meta charset='UTF - 8'><title>update</title>");
        pw.println("<link rel='stylesheet' type='text/css' href='sty.css'/> </head>");
        pw.println("<body>");
        pw.println("<form action='/usermgr/userUpdateByAdminAction' method='post'>");
        pw.println("<table>");
        pw.println("<tr><th colspan='2'> 修改用户信息 </th> </tr>");
        pw.println("<tr><td> id </td><td><input type='text' name='id' value='" + u.getId() + "' readonly></td></tr>");
        pw.println("<tr><td> username </td><td><input type='text' name='username' value='" + u.getUsername() + "'></td></tr>");
        pw.println("<tr><td> password </td><td><input type='password' name='password' value='" + u.getPassword() + "'></td> </tr>");
        pw.println("<tr><td> age </td><td><input type='number' name='age' value='" + u.getAge() + "'></td></tr>");
        pw.println("<tr><td> email </td> <td><input type='email' name='email' value='" + u.getEmail() + "'></td></tr>");
        pw.println("<tr><td> address </td><td><input type='text' name='address' value='" + u.getAddress() + "'></td></tr>");
        pw.println("<tr><td><input type='submit' value='修改'></td> </tr>");
        pw.println("</table></form></body></html>");
        pw.close();
    }
}
