package GameObjects.Projectiles;
import GameObjects.Ships.Ship;
import Graphics.Assets;
import java.awt.*;

public class SimpleLaserProjectile extends Projectile {
    public SimpleLaserProjectile(float x, float y, int width, int height, float xDirection, float yDirection) {
        super(x, y, width, height, xDirection, yDirection);
        this.texture = Assets.laser01;
    }

    @Override
    public void modify(Ship s) {
        s.hitPoints-= 10;
    }
}
