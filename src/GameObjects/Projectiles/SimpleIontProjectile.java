package GameObjects.Projectiles;

import GameObjects.Ships.Ship;
import Graphics.Assets;

import java.awt.*;

public class SimpleIontProjectile extends Projectile {

    public SimpleIontProjectile(float x, float y, int width, int height, float xDirection, float yDirection) {
        super(x, y, width, height, xDirection, yDirection);
        this.texture = Assets.iont01;
    }

    @Override
    public void modify(Ship s) {
        s.hitPoints -= 20;
    }
}
