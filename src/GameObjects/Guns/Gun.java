package GameObjects.Guns;

import Game.Game;
import GameObjects.Ships.Ship;
import states.GameState;

public abstract class Gun {

    int freq,timer,xDirection,yDirection, xOffset, yOffset;
    public abstract void fire();
    public abstract void reload();
    Game game;
    Ship ship;

    public Gun(int timer, int xDirection, int yDirection, Game game, Ship ship) {
        this.freq = 0;
        this.timer = timer;
        this.xDirection = xDirection;
        this.yDirection = yDirection;
        this.game = game;
        this.ship = ship;
        xOffset =0;
        yOffset =0;
    }
    public void setOffset(int x , int y){
        xOffset = x;
        yOffset = y;
    }

}
