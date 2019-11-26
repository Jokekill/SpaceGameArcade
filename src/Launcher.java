import Game.Game;

public class Launcher {
    public static void main(String[] args){
        Game game = new Game("Tile Game!", 640, 640);
        game.start();
    }
}
