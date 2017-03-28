package cn.gjp0609.web.user_management.v2.action;

import cn.gjp0609.web.user_management.v2.utils.Verifiy;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by gjp06 on 17.3.27.
 */
@WebServlet(name = "VerifiyCodeAction")
public class VerifiyCodeAction extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        char[] vcode = Verifiy.getVerifiyCode(4);
        BufferedImage img = Verifiy.getVerifiyImg(vcode);

        req.getSession().setAttribute("vcode", vcode);

        ImageIO.write(img, "png", resp.getOutputStream());
    }
}
