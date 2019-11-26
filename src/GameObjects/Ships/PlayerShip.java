package GameObjects.Ships;

import Game.Game;
import GameObjects.Guns.SimpleIontGun;
import GameObjects.Guns.SimpleLaserGun;
import GameObjects.Guns.Gun;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GameObjects.Projectiles.Projectile;
import Graphics.Assets;
import javafx.scene.control.skin.CellSkinBase;
import states.GameState;

public class PlayerShip extends Ship {

    BufferedImage texture;


    public PlayerShip(float x, float y, int width, int height, Game game) {
        super(x, y, width, height, game);

        guns = new ArrayList<>();
        SimpleLaserGun l = new SimpleLaserGun(10,0,-4, game, this);
        l.setOffset(15,-7);
        guns.add(l);
        SimpleIontGun I = (new SimpleIontGun(35,(float)-0.25,(float)-3, game, this));
        guns.add(I);
        I.setOffset(-9,-1);
        I = new SimpleIontGun(35,(float)0.25,(float)-3, game, this);
        I.setOffset(32,-1);
        guns.add(I);
        maxHitPoints = 100;
        hitPoints = maxHitPoints;
        speed = 3;
    }


    @Override
    public void update() {
        if(game.getKeyBoardInput().up)
            y -= speed;
        if(game.getKeyBoardInput().down)
            y += speed;
        if(game.getKeyBoardInput().left)
            x -= speed;
        if(game.getKeyBoardInput().right)
            x += speed;
        if (game.getKeyBoardInput().space) for (Gun g: guns )  g.fire();
        else for (Gun g: guns )   g.reload();

    }

    @Override
    public void render(Graphics g) {
        if (checkExistence()) g.drawImage(Assets.explosion01,(int)x, (int)y, null);
        else {
            g.drawImage(Assets.ship01, (int) x, (int) y, null);
            renderHitPointsBar(g);
        }
    }


    @Override
    public void getHit(Projectile p) {
            p.modify(this);
    }

    @Override
    public boolean checkExistence() {
        return hitPoints<=0;
    }

    private void renderHitPointsBar(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect((int)x,(int)y +height +3, (int)  ((width) * hitPoints/maxHitPoints), 4);
    }
}
