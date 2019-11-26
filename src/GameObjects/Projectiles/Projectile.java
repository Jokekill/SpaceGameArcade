package GameObjects.Projectiles;

import GameObjects.GameObject;
import GameObjects.Ships.Ship;

import java.awt.*;
import java.awt.image.BufferedImage;

public  class Projectile extends GameObject {
    public float xDirection,yDirection;
    public BufferedImage texture;

    public Projectile(float x, float y, int width, int height, float xDirection, float yDirection) {
        super(x, y, width, height);
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }
    public  void modify(Ship s){}

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
