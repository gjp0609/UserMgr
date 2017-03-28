package cn.gjp0609.web.user_management.v2.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.Random;

/**
 * 创建
 * Created by gjp06 on 17.3.27.
 */
public class BGImage {
    private static final int WIDTH = 1400;
    private static final int HEIGHT = 900;
    private static final String[] fonts = {"Chiller", "Mistral", "Papyrus"};
    private static final Color[] COLORS = {Color.BLUE, Color.BLACK, Color.MAGENTA, Color.RED, Color.GREEN};

    public static BufferedImage getBGImg() {

        BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Random random = new Random();
        Graphics g = img.getGraphics();

        for (int i = 0; i < WIDTH; i += random.nextInt(500)) {
            for (int j = 0; j < HEIGHT; j += random.nextInt(500)) {
                int r = random.nextInt(300) + 100;
                g.setColor(new Color(random.nextInt(100) + 155, random.nextInt(100) + 155,
                        random.nextInt(100) + 155, random.nextInt(130)));
                g.fillRoundRect(random.nextInt(WIDTH) - 200, random.nextInt(HEIGHT) - 200, r, r, r, r);
            }
        }

        g.dispose();
        return img;
    }

    public static void main(String[] args) throws Exception {
        BufferedImage image = getBGImg();
        ImageIO.write(image, "png", new FileOutputStream("src/a.png"));
    }
}
