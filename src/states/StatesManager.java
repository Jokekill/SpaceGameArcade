package states;

public class StatesManager {
    private static State currentState;

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State currentState) {
        StatesManager.currentState = currentState;
    }
}
