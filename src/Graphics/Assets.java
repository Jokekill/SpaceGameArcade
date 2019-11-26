package Graphics;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage ship01,ship02,laser01,laser02,iont01, explosion01;

    public static void init()
    {
        ship01 = ImageLoader.loadImage("/textures/ship01.png");
        ship02 = ImageLoader.loadImage("/textures/ship02.png");
        laser01 = ImageLoader.loadImage("/textures/laser01.png");
        laser02 = ImageLoader.loadImage("/textures/laser02.png");
        iont01 = ImageLoader.loadImage("/textures/iont01.png");
        explosion01 = ImageLoader.loadImage("/textures/explosion01.png");
    }


}
