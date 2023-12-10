//Factory which randomly creates and returns an Event

import java.util.Random;

public class EventFactory {
    public static Event createRandomEvent() {
        String[] eventTypes = {
            "invasion", "famine", "plague", "treasure discovery", "diplomatic",
            "natural disaster", "trade opportunity", "bandit attack", "festival",
            "monster attack", "magic artifact discovery", "economic boom",
            "political scandal", "drought", "heroic deed", "alien invasion",
            "art thieves", "rebellion", "time travel"
        };

        // Choose a random event
        Random random = new Random();
        String randomEventType = eventTypes[random.nextInt(eventTypes.length)];

        // Create and return the chosen event
        return createEvent(randomEventType);
    }

    public static Event createEvent(String eventType) {
        switch (eventType.toLowerCase()) {
            case "invasion":
                return new InvasionEvent();
            case "famine":
                return new FamineEvent();
            case "plague":
                return new PlagueEvent();
            case "treasure discovery":
                return new TreasureDiscoveryEvent();
            case "diplomatic":
                return new DiplomaticEvent();
            case "natural disaster":
                return new NaturalDisasterEvent();
            case "trade opportunity":
                return new TradeOpportunityEvent();
            case "bandit attack":
                return new BanditAttackEvent();
            case "festival":
                return new FestivalEvent();
            case "monster attack":
                return new MonsterAttackEvent();
            case "magic artifact discovery":
                return new MagicArtifactDiscoveryEvent();
            case "economic boom":
                return new EconomicBoomEvent();
            case "political scandal":
                return new PoliticalScandalEvent();
            case "drought":
                return new DroughtEvent();
            case "heroic deed":
                return new HeroicDeedEvent();
            case "alien invasion":
                return new AlienInvasionEvent();
            case "art thieves":
                return new ArtThievesEvent();
            case "rebellion":
                return new RebellionEvent();
            case "time travel":
                return new TimeTravelEvent();
            default:
                throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
    }
}