package GameObjects;

import java.awt.*;

public abstract class GameObject {
    public float x, y;
    public int width,height;
    public abstract void update();
    public abstract void render(Graphics g);

    public GameObject(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
