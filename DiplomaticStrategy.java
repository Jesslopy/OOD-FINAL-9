//Interchangeable strategy which assigns resource multipliers in certain areas.

public class DiplomaticStrategy implements Strategy {
    @Override
    public void executeStrategy(Character character, GameState gameState) {
        System.out.println(character.getName() + " is engaging in diplomacy.");
        System.out.println("All Influence and Wealth gain increased by 1.5x");

        int currentInfluence = character.getInfluence();
        int currentWealth = character.getWealth();

        int increasedInfluence = (int) Math.round(currentInfluence * 1.5);
        int increasedWealth = (int) Math.round(currentWealth * 1.5);

        character.setInfluence(increasedInfluence);
        character.setWealth(increasedWealth);
    }
}