//Strategy used to make Strategies interchangeable and easily implementable

public interface Strategy {
    void executeStrategy(Character character, GameState gameState);
}
