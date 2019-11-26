package GameObjects.Ships;

import Game.Game;
import GameObjects.Guns.SimpleIontGun;
import GameObjects.Guns.SimpleLaserGun;
import GameObjects.Guns.Gun;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Graphics.Assets;
import javafx.scene.control.skin.CellSkinBase;
import states.GameState;

public class PlayerShip extends Ship {

    Game game;
    BufferedImage texture;


    public PlayerShip(float x, float y, int width, int height, float hitPoints, Game game) {
        super(x, y, width, height, hitPoints);
        this.game = game;

        guns = new ArrayList<>();
        SimpleLaserGun l = new SimpleLaserGun(10,0,-4, game, this);
        l.setOffset(15,-7);
        guns.add(l);
        SimpleIontGun I = (new SimpleIontGun(35,-1,-2, game, this));
        guns.add(I);
        I.setOffset(-9,-1);
        I = new SimpleIontGun(35,1,-2, game, this);
        I.setOffset(32,-1);
        guns.add(I);
    }


    @Override
    public void update() {
        if(game.getKeyBoardInput().up)
            y -= 3;
        if(game.getKeyBoardInput().down)
            y += 3;
        if(game.getKeyBoardInput().left)
            x -= 3;
        if(game.getKeyBoardInput().right)
            x += 3;
        if (game.getKeyBoardInput().space) for (Gun g: guns )  g.fire();
        else for (Gun g: guns )   g.reload();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.ship01,(int)x, (int)y, null);
    }


}
