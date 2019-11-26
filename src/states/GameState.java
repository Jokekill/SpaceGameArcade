package states;

import Game.Game;
import GameObjects.GameObject;
import GameObjects.Projectiles.Projectile;
import GameObjects.Projectiles.SimpleLaserProjectile;
import GameObjects.Ships.PlayerShip;
import GameObjects.Ships.Ship;

import java.awt.*;
import java.util.ArrayList;

public class GameState extends State {
    private PlayerShip playerShip;

    private ArrayList<GameObject> gameObjects;
    private ArrayList<GameObject> newGameObjects;

    public GameState(Game game) {
        super(game);
        playerShip = new PlayerShip(50,50, 32,32,25,game);
        gameObjects = new ArrayList<>();
        newGameObjects = new ArrayList<>();
        gameObjects.add(playerShip);
    }

    @Override
    public void update() {
        // TODO add filtering
        disposeUnused();
        for (GameObject g : gameObjects) g.update();
        for (GameObject g : newGameObjects) gameObjects.add(g);
        newGameObjects = new ArrayList<>();

    }

    @Override
    public void render(Graphics g) {
        for (GameObject go : gameObjects) go.render(g);
    }

    public void addNewProjectile(Projectile p)
    {
        newGameObjects.add(p);
    }

    private void disposeUnused(){
        ArrayList<GameObject> objectsToRemove = new ArrayList<>();
        for (GameObject go: gameObjects
             ) {
            if (go.x < 0 || go.x > game.width || go.y < 0 || go.y > game.height)
                if ( go.getClass() == (new Projectile(0,0,0,0,0,0)).getClass()){
                    objectsToRemove.add(go);
                }
            //TODO return ships back to playing field
        }
        for (GameObject go: objectsToRemove
             ) {
            gameObjects.remove(go);
        }
    }
    private void checkForCollisions()
    {
        ArrayList<GameObject> objectsToRemove = new ArrayList<>();
        for (GameObject go1: gameObjects)
        {
            if ( go1 instanceof Projectile)
            for (GameObject go2: gameObjects) {
                if(go2 instanceof Ship){
                    if (go2.x > go1.x && go2.x < (go1.x+go1.width) && go2.y > go1.y && go2.y < (go1.y+go1.height))
                    {
                        objectsToRemove.add(go1);
                    }
                }
            }
        }

    }
}
