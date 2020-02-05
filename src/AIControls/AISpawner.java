package AIControls;

import Game.Game;
import GameObjects.Ships.BasicShip;
import GameObjects.Ships.Ship;

public class AISpawner {
     Game game;

     public int numLivingAI, maxAI;
     float hardness;

    public AISpawner(Game game) {
        this.game = game;
        hardness = 0;
    }

    public Ship addAI(float x, float y)
    {
        if  (numLivingAI < maxAI) {
            numLivingAI++;

            BasicShip bs = new BasicShip(x, y, 32, 32, game);
            bs.modifyMovementSpeed(hardness);
            hardness += 0.2;
            return bs;
        }
        return null;
    }

}
