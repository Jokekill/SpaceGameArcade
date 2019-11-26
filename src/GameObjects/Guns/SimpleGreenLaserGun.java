package GameObjects.Guns;

import Game.Game;
import GameObjects.Projectiles.SimpleLaserGreenProjectile;
import GameObjects.Projectiles.SimpleLaserProjectile;
import GameObjects.Ships.Ship;

public class SimpleGreenLaserGun extends Gun {

    public SimpleGreenLaserGun(int timer, float xDirection, float yDirection, Game game, Ship ship) {
        super(timer, xDirection, yDirection, game, ship);
    }

    @Override
    public void fire() {
        if (timer< freq) {
            game.currGameState.addNewProjectile(new SimpleLaserGreenProjectile(ship.x + xOffset, ship.y+ yOffset, 2, 8, xDirection, yDirection));
            freq = 0;
        }
        else freq++;
    }

    @Override
    public void reload() {
        freq++;
    }
}
