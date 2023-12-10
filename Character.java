//Class which holds all character-related variables and functions
public class Character {
    private String name;
    private int health;
    private int strength;
    private Component currentLocation;
    private int wealth; 
    private int influence; 
    private Strategy strategy;


    public Character(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.wealth = 0; 
        this.influence = 0; 
        this.currentLocation = currentLocation;
    }


    public void setWealth(int wealth) {
        this.wealth = wealth;
    }
    
    public void setInfluence(int influence) {
        this.influence = influence;
    }
    
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Component getCurrentLocation() {
        return currentLocation;
    }

    public void increaseWealth(int amount) {
        this.wealth += amount;
    }

    public void increaseHealth(int amount) {
        this.health += amount;
    }

    public void increaseInfluence(int amount) {
        this.influence += amount;
    }


    public void displayResources() {
        System.out.println("Health: " + health);
        System.out.println("Strength: " + strength);
        System.out.println("Wealth: " + wealth);
        System.out.println("Influence: " + influence);
    }



    public void increaseStrength(int amount){
        this.strength += amount;
    }

    public void decreaseHealth(int amount) {
        this.health -= amount;
        if (this.health < 0) this.health = 0;
    }

    public void decreaseStrength(int amount) {
        this.strength -= amount;
        if (this.strength < 0) this.strength = 0;
    }

    public void decreaseInfluence(int amount) {
        this.influence -= amount;
        if (this.influence < 0) this.influence = 0;
    }

    public void decreaseWealth(int amount) {
        this.wealth -= amount;
        if (this.wealth < 0) this.wealth = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }



    public int getWealth() {
        return wealth;
    }

    public int getInfluence() {
        return influence;
    }


    public void setCurrentLocation(Component currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void interactWithEvent(Event event) {
        event.triggerEvent(this);
    }
}