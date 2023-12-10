//Interchangeable strategy which assigns resource multipliers in certain areas.

public class DefensiveStrategy implements Strategy {
    @Override
    public void executeStrategy(Character character, GameState gameState) {
        System.out.println(character.getName() + " is using a defensive strategy.");
        System.out.println("All Strength and Health gain increased by 1.5x");

        int currentStrength = character.getStrength();
        int currentHealth = character.getHealth();

        int increasedStrength = (int) Math.round(currentStrength * 1.5);
        int increasedHealth = (int) Math.round(currentHealth * 1.5);

        character.setStrength(increasedStrength);
        character.setHealth(increasedHealth);
    }
}