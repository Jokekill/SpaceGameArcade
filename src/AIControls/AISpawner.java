package AIControls;

import Game.Game;
import GameObjects.Ships.BasicShip;
import GameObjects.Ships.Ship;

public class AISpawner {
    Game game;

     public int numLivingAI, maxAI;

    public AISpawner(Game game) {
        this.game = game;
    }

    public Ship addAI(float x, float y)
    {
        if  (numLivingAI < maxAI) {
            numLivingAI++;
            return new BasicShip(x, y, 32, 32, game);
        }
        return null;
    }

}
