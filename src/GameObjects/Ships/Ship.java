package GameObjects.Ships;

import GameObjects.GameObject;
import GameObjects.Guns.Gun;

import java.awt.*;
import java.util.ArrayList;

public abstract class Ship extends GameObject {

    float hitPoints;
    int oriantation;
    ArrayList<Gun> guns;


    public Ship(float x, float y, int width, int height, float hitPoints) {
        super(x, y, width, height);
        this.hitPoints = hitPoints;
    }
}
