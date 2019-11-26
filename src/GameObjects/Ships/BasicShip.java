package GameObjects.Ships;

import AIControls.MovementControl;
import Game.Game;
import GameObjects.Guns.Gun;
import GameObjects.Guns.SimpleGreenLaserGun;
import GameObjects.Guns.SimpleRedLaserGun;
import GameObjects.Projectiles.Projectile;
import Graphics.Assets;

import java.awt.*;
import java.util.ArrayList;

public class BasicShip extends Ship {

    MovementControl movementControl;
    public BasicShip(float x, float y, int width, int height, Game game) {
        super(x, y, width, height, game);
        guns = new ArrayList<>();
        SimpleGreenLaserGun l = new SimpleGreenLaserGun(50,0,4, game, this);
        l.setOffset(15,37);
        guns.add(l);

        movementControl = new MovementControl(game.width,game.height);
        maxHitPoints = 100;
        hitPoints = maxHitPoints;
        speed = 10;
    }

    @Override
    public void getHit(Projectile p) {
        p.modify(this);
    }

    @Override
    public boolean checkExistence() {
        return hitPoints<=0;
    }

    @Override
    public void update() {
        x = x + movementControl.vertical(this);
        for (Gun g: guns )   g.fire();
        for (Gun g: guns )   g.reload();
    }

    @Override
    public void render(Graphics g) {

        if (checkExistence()) g.drawImage(Assets.explosion01, (int) x, (int) y, null);
        else {
            g.drawImage(Assets.ship02, (int) x, (int) y, null);
            renderHitPointsBar(g);
        }
    }

    private void renderHitPointsBar(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect((int)x,(int)y  -4, (int)  ((width) * hitPoints/maxHitPoints), 2);
    }
}
