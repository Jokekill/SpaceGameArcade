package AIControls;

import GameObjects.Ships.Ship;

public class MovementControl {
    int width,height;
    int state;

    public MovementControl(int width, int height) {
        this.width = width;
        this.height = height;
        state = 0;
    }

    public int horizontal(Ship s){
        return 0;
    }
    public int vertical(Ship s){
        if (s.x + s.width <= width && state == 0 ) return 1;
        if (s.x  >= 0 && state == 1 ) return -1;
        if (s.x + s.width >= width && state == 0 ) {
            state=1;
            return -1;
        }
        if (s.x  <= 0 && state == 1 ) {
            state=0;
            return 1;
        }
        return 0;

    }
    private void changeState(){

    }

}
