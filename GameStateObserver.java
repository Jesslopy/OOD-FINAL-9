//Obersver for viewing and updating current GameState

public class GameStateObserver implements Observer {

    @Override
    public void update() {
        System.out.println("GameState has been updated.");
    }
}