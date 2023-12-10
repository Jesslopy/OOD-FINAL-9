import java.util.List;
import java.util.ArrayList;

public class Location implements Component {
    private String name;

    public Location(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        //
    }

    @Override
    public void remove(Component component) {
        //
    }

    @Override
    public String display() {
        return "Location: " + name;
    }

    @Override
    public List<Character> getCharacters() {
        return new ArrayList<>();
    }
}