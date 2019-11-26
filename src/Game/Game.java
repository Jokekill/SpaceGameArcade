package Game;

import Display.Display;
import Input.KeyBoardInput;
import states.GameState;
import states.MenuState;
import states.State;
import states.StatesManager;
import Graphics.Assets;



import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements  Runnable{

    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private StatesManager statesManager;
    private State gameState;
    private State menuState;
    public GameState currGameState;

    public KeyBoardInput getKeyBoardInput() {
        return keyBoardInput;
    }

    private KeyBoardInput keyBoardInput;


    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init(){
        display = new Display(title, width, height);
        menuState = new MenuState(this);
        gameState = new GameState(this);
        statesManager.setCurrentState(gameState); //TODO chanche back to menustate
        keyBoardInput = new KeyBoardInput();
        display.getFrame().addKeyListener(keyBoardInput);
        Assets.init();

        currGameState = (GameState)gameState;
    }

    public GameState getGameState(){
        return ( GameState) statesManager.getCurrentState();
    }

    private void update(){
        keyBoardInput.update();
        StatesManager.getCurrentState().update();

    }
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Here!
        g.setColor(Color.BLACK);
        g.fillRect(0,0,width,height);
        StatesManager.getCurrentState().render(g);

        //End Drawing!
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                update();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
