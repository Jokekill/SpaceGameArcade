package GameObjects.Projectiles;

import GameObjects.GameObject;
import Graphics.Assets;

import java.awt.*;

public class Explosion extends GameObject {

    public int timer;
    public Explosion(float x, float y, int width, int height, int timer) {
        super(x, y, width, height);
        this.timer = timer;
    }

    @Override
    public void update() {
        timer--;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.explosion01,(int)x,(int)y,null);
    }
}
