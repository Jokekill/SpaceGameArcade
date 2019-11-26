package GameObjects.Guns;

import Game.Game;
import GameObjects.Projectiles.SimpleIontProjectile;
import GameObjects.Projectiles.SimpleLaserProjectile;
import GameObjects.Ships.Ship;

public class SimpleIontGun extends Gun {
    public SimpleIontGun(int timer, int xDirection, int yDirection, Game game, Ship ship) {
        super( timer, xDirection, yDirection, game, ship);
    }

    @Override
    public void fire() {
        if (timer< freq) {
            game.currGameState.addNewProjectile(new SimpleIontProjectile(ship.x+xOffset, ship.y+yOffset, 9, 9,xDirection, yDirection));
            freq = 0;
        }
        else freq++;
    }
    @Override
    public void reload() {
        freq++;
    }
}
