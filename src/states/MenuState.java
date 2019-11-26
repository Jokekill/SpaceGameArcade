package states;

import Game.Game;

import java.awt.*;

public class MenuState extends State {
    public MenuState(Game game) {
        super(game);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawOval(40 ,40 ,58 , 60);
    }
}
