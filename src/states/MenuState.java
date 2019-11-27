package states;

import Game.Game;

import java.awt.*;

public class MenuState extends State {
    int timer;
    int counter;
    public MenuState(Game game) {
        super(game);
        counter = 0;
        timer = 10;
    }

    @Override
    public void update() {
        if (counter >= 60) {
            counter =0;
            timer--;
        }
        if(timer == 0){
            game.startNewGame();
        }
        counter++;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(40 ,40 ,58 , 60);
        g.drawString("Respawn in: " + timer, game.width >>1 , game.height >>1);
    }
}
