package cn.gjp0609.web.user_management.v2.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.Random;

/**
 * 创建随机验证码
 * Created by gjp06 on 17.3.27.
 */
public class Verifiy {
    private static final int WIDTH = 170 * 4;
    private static final int HEIGHT = 50 * 4;
    private static final String[] fonts = {"Chiller", "Mistral", "Papyrus"};
    private static final Color[] COLORS = {Color.BLUE, Color.BLACK, Color.MAGENTA, Color.RED, Color.GREEN};


    public static char[] getVerifiyCode(int number) {
        String strs = "1234567890QWERTYUIOPLKJHGFDSAZXCVBNM";
//        String strs = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
        Random random = new Random();
        char[] vcode = new char[number];
        for (int i = 0; i < vcode.length; i++)
            vcode[i] = strs.charAt(random.nextInt(strs.length()));
        return vcode;
    }

    public static BufferedImage getVerifiyImg(char[] vcode) {

        BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Random random = new Random();
        Graphics g = img.getGraphics();

        for (int i = 0; i < vcode.length; i++) {
            g.setColor(COLORS[random.nextInt(COLORS.length)]);
            Font f = new Font(fonts[random.nextInt(fonts.length)], Font.ITALIC + Font.BOLD, 40 * 4);
            g.setFont(f);
            g.drawString(vcode[i] + "", 40 * i * 4, 36 * 4);
        }

        g.dispose();
        return img;
    }

    public static void main(String[] args) throws Exception {
        char[] vcode = getVerifiyCode(4);
        BufferedImage image = getVerifiyImg(vcode);
        ImageIO.write(image, "png", new FileOutputStream("src/a.png"));
    }
}
