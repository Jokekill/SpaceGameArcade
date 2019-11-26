package GameObjects.Projectiles;

import Graphics.Assets;

import java.awt.*;

public class SimpleIontProjectile extends Projectile {

    public SimpleIontProjectile(float x, float y, int width, int height, int xDirection, int yDirection) {
        super(x, y, width, height, xDirection, yDirection);
        this.texture = Assets.iont01;
    }
}
