package GameObjects.Projectiles;
import GameObjects.Ships.Ship;
import Graphics.Assets;

public class SimpleLaserGreenProjectile extends Projectile {
    public SimpleLaserGreenProjectile(float x, float y, int width, int height, float xDirection, float yDirection) {
        super(x, y, width, height, xDirection, yDirection);
        this.texture = Assets.laser02;
    }

    @Override
    public void modify(Ship s) {
        s.hitPoints-= 10;
    }
}
