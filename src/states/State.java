package states;

import Game.Game;

import java.awt.*;


public abstract class State {
    protected Game game;
    public abstract void update();
    public abstract void render(Graphics g);

    public State(Game game) {
        this.game = game;
    }
}
