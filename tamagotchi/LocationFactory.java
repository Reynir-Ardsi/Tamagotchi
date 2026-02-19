package tamagotchi;

public class LocationFactory {
    public static Location createLocation(Location.Type locationType) {
        return switch (locationType) { //Switch Expression that accesses the subclass directly, returning its value also directly
            case LOBBY -> new Lobby();
            case KITCHEN -> new Kitchen();
            case PLAYGROUND -> new Playground();
            case GYM -> new Gym();
        };
    }
}
