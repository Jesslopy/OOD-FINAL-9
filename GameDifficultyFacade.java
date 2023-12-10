//Facade that allows user to choose a starting difficulty to be saved to GameState

public class GameDifficultyFacade {
    private GameState gameState;

    public GameDifficultyFacade(GameState gameState) {
        this.gameState = gameState;
    }

    public int getAllocationPointsForDifficulty(String difficulty) {
        switch (difficulty.toLowerCase()) {
            case "easy":
                return 200; 
            case "normal":
                return 150; 
            case "hard":
                return 100;
            default:
                return 200;
        }
    }
}
