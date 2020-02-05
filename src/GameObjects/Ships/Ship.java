package GameObjects.Ships;

import Game.Game;
import GameObjects.GameObject;
import GameObjects.Guns.Gun;
import GameObjects.Projectiles.Projectile;

import java.awt.*;
import java.util.ArrayList;

public abstract class Ship extends GameObject {

    public float hitPoints;
    Game game;
    int maxHitPoints;;
    ArrayList<Gun> guns;
    float speed;
    public abstract void getHit(Projectile p);
    public abstract boolean checkExistence();


    public Ship(float x, float y, int width, int height, Game game) {
        super(x, y, width, height);
        this.game = game;

    }
}
