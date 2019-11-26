package GameObjects.Projectiles;
import Graphics.Assets;
import java.awt.*;

public class SimpleLaserProjectile extends Projectile {
    public SimpleLaserProjectile(float x, float y, int width, int height, int xDirection, int yDirection) {
        super(x, y, width, height, xDirection, yDirection);
        this.texture = Assets.laser01;
    }
}
