import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameState {
    private List<Character> characters;
    private List<Observer> observers = new ArrayList<>();

    public GameState() {
        characters = new ArrayList<>();
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }


    private Character getRandomCharacter() {
        if (characters.size() > 0) {
            int index = new Random().nextInt(characters.size());
            return characters.get(index);
        }
        return null;
    }
}