package GameObjects.Projectiles;

import GameObjects.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Projectile extends GameObject {
    public int xDirection,yDirection;
    public BufferedImage texture;

    public Projectile(float x, float y, int width, int height, int xDirection, int yDirection) {
        super(x, y, width, height);
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }

    @Override
    public void update() {
        x += xDirection;
        y += yDirection;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(texture,(int) x, (int) y, null);
    }
}
