package states;

import AIControls.AISpawner;
import Game.Game;
import GameObjects.GameObject;
import GameObjects.Projectiles.Explosion;
import GameObjects.Projectiles.Projectile;
import GameObjects.Projectiles.SimpleLaserProjectile;
import GameObjects.Ships.BasicShip;
import GameObjects.Ships.PlayerShip;
import GameObjects.Ships.Ship;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameState extends State {
    private PlayerShip playerShip;

    private ArrayList<GameObject> gameObjects;
    private ArrayList<GameObject> newGameObjects;

    private AISpawner spawner;
    private Random random;

    public GameState(Game game) {
        super(game);
        playerShip = new PlayerShip(game.width >> 1,game.height -40, 32,32,game);
        gameObjects = new ArrayList<>();
        newGameObjects = new ArrayList<>();
        gameObjects.add(playerShip);
        gameObjects.add(new BasicShip(250,50,32,32,game));
        random = new Random(42);
        spawner = new AISpawner(game);
        spawner.maxAI = 5;
        spawner.numLivingAI = 0;

    }

    @Override
    public void update() {
        // TODO add filtering
        disposeUnused();
        checkForCollisions();
        Ship newShip = spawner.addAI((float) random.nextInt(game.width),50);
        if (newShip != null)
        {
            gameObjects.add(newShip);
        }
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
            if (go instanceof Ship )
            {
                if (go instanceof PlayerShip  && ((Ship) go).hitPoints <= 0) {
                    game.returnToMenu();
                    return;
                }
                if (((Ship) go).hitPoints <= 0) {
                    objectsToRemove.add(go);
                    newGameObjects.add(new Explosion(go.x, go.y, 32, 32, 100));
                }
            }
            if (go instanceof Explosion)
            {
                if (((Explosion) go).timer <= 0) {
                    objectsToRemove.add(go);
                    spawner.numLivingAI--;
                }
            }
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
                    if (go2.x < go1.x && go1.x < (go2.x+go2.width) && go2.y < go1.y && go1.y < (go2.y+go2.height))
                    {
                        System.out.println("COLLISION");
                        objectsToRemove.add(go1);
                        ((Ship) go2).getHit((Projectile) go1);
                    }
                }
            }
        }
        for (GameObject go: objectsToRemove
        ) {
            gameObjects.remove(go);
        }

    }
}
