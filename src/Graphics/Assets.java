package Graphics;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage ship01,laser01,iont01;

    public static void init()
    {
        ship01 = ImageLoader.loadImage("/textures/ship01.png");
        laser01 = ImageLoader.loadImage("/textures/laser01.png");
        iont01 = ImageLoader.loadImage("/textures/iont01.png");
    }


}
