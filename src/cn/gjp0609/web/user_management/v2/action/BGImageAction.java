package cn.gjp0609.web.user_management.v2.action;

import cn.gjp0609.web.user_management.v2.utils.BGImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 创建背景图片的 action
 * Created by gjp06 on 17.3.27.
 */
@WebServlet(name = "BGImageAction")
public class BGImageAction extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 获得图片
        BufferedImage img = BGImage.getBGImg();

        ImageIO.write(img, "png", resp.getOutputStream());
    }
}
