//Driver

import java.util.Scanner;

public class TowerConquestGame {
    private GameState gameState;
    private Character playerCharacter;
    private int weekCounter = 0;
    private Strategy playerStrategy;
    private int count;

    public TowerConquestGame() {
        gameState = new GameState();
        initializeGameElements();
    }

    private void initializeGameElements() {
        Character hero = new Character("Hero", 100, 10);
        gameState.addCharacter(hero);
        playerCharacter = new Character("Player", 100, 10);
        gameState.addCharacter(playerCharacter);
    }

    private void allocatePoints(int alloted_points) {
        Scanner scanner = new Scanner(System.in);
        boolean pointsAllocated = false;
    
        while (!pointsAllocated) {
            count = 0; 
            System.out.println("You have " + alloted_points + " points to allocate to Health, Strength, Wealth, and Influence.");
    
            System.out.print("Enter points for Health: ");
            int healthPoints = scanner.nextInt();
            count += healthPoints;
    
            System.out.print("Enter points for Strength: ");
            int strengthPoints = scanner.nextInt();
            count += strengthPoints;
    
            System.out.print("Enter points for Wealth: ");
            int wealthPoints = scanner.nextInt();
            count += wealthPoints;
    
            System.out.print("Enter points for Influence: ");
            int influencePoints = scanner.nextInt();
            count += influencePoints;
    
            if (count <= alloted_points) {
                playerCharacter.setHealth(healthPoints);
                playerCharacter.setStrength(strengthPoints);
                playerCharacter.setWealth(wealthPoints);
                playerCharacter.setInfluence(influencePoints);
                pointsAllocated = true; 
            } else {
                System.out.println("Your point allocation exceeds " + alloted_points + " points! Please try again.");
            }
        }
    }

    private void assignStrategy(String strategyName) {
        switch (strategyName.toLowerCase()) {
            case "aggressive":
                playerStrategy = new AggressiveStrategy();
                break;
            case "defensive":
                playerStrategy = new DefensiveStrategy();
                break;
            case "diplomatic":
                playerStrategy = new DiplomaticStrategy();
                break;
            default:
                System.out.println("Invalid strategy. Defaulting to Aggressive.");
                playerStrategy = new AggressiveStrategy();
        }
        if (playerCharacter != null) {
            playerCharacter.setStrategy(playerStrategy);
        }
    }

    private void processWeek() {
        Event event = EventFactory.createRandomEvent(); 
        if (event != null) {
            event.triggerEvent(playerCharacter);
            playerCharacter.displayResources();

        } else {
            System.out.println("No random event available.");
        }
    
    }

    private boolean checkGameOver() {
        if (playerCharacter.getHealth() <= 0 ||
            playerCharacter.getStrength() <= 0 ||
            playerCharacter.getWealth() <= 0 ||
            playerCharacter.getInfluence() <= 0) {
            return true; 
        }
        return false; 
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tower Conquest!");
        System.out.println("The objective is to allocate points for your character, then respond to in-game events by using commands");
        System.out.print("Choose game difficulty for the number of allocation points (easy (200), normal (150), hard (100)): ");
        String difficulty = scanner.nextLine();
        GameDifficultyFacade difficultyFacade = new GameDifficultyFacade(gameState);
        int allocationPoints = difficultyFacade.getAllocationPointsForDifficulty(difficulty);



        System.out.print("Enter your character's name: ");
        String playerName = scanner.nextLine();
        playerCharacter.setName(playerName);
    
        System.out.print("Enter the name of your kingdom: ");
        String kingdomName = scanner.nextLine();
        Location kingdomLocation = new Location(kingdomName); // Create a Location object
        playerCharacter.setCurrentLocation(kingdomLocation);


        allocatePoints(allocationPoints);

        // Strategy selection
        System.out.println("You will now choose a Strategy. Aggressive [Wealth and Strength 1.5x], Defensive [Strength and Health 1.5x], Diplomatic [Influence and Wealth 1.5x]");
        System.out.print("Choose your strategy (Aggressive, Defensive, Diplomatic): ");
        String strategyName = scanner.nextLine();
        assignStrategy(strategyName);
        playerStrategy.executeStrategy(playerCharacter, gameState);



        System.out.println("The game starts now! Your objective is to survive as many weeks as possible without letting any points drop to zero.");

        while (true) {
            weekCounter++;
            System.out.println();
            System.out.println("Week " + weekCounter + ":");
            System.out.println("Resources at the start of the week:");
            playerCharacter.displayResources();
            System.out.println();
            processWeek();

            if (checkGameOver()) {
                System.out.println("Game Over! Your kingdom has collapsed! You survived " + weekCounter + " weeks.");
                break;
            }

            System.out.println("Enter command for this week: strengthen, heal, mine, debate, exit");
            String command = scanner.nextLine();
            switch (command.toLowerCase()) {
                case "strengthen":
                    playerCharacter.setStrength(playerCharacter.getStrength() + 10); 
                    System.out.println("Your army spent the week conditioning +10 Strength");
                    break;
                case "heal":
                    // Assuming you have a method to increase health
                    playerCharacter.increaseHealth(10); 
                    System.out.println("You spent the week recovering +10 Health");
                    break;
                case "mine":
                    playerCharacter.increaseWealth(10); 
                    System.out.println("Your miners found gold +10 Wealth");
                    break;
                case "debate":
                    playerCharacter.increaseInfluence(10); 
                    System.out.println("You hosted a successful debate +10 Influence");
                    break;
                case "exit":
                    System.out.println("Exiting game after " + weekCounter + " weeks.");
                    return; 
                default:
                    System.out.println("Unknown command. Please try again.");
                    break;
            }

        }

        scanner.close();
    }

    public static void main(String[] args) {
        TowerConquestGame game = new TowerConquestGame();
        game.startGame();
    }
}