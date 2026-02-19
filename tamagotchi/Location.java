package tamagotchi;



public abstract class Location {

    // Enum to define different location types
    public enum Type {
        LOBBY, KITCHEN, PLAYGROUND, GYM; //enumeration data type
    }

    private final Type locationType;

    protected Location(Type locationType) {
        this.locationType = locationType;
    }

    public Type getLocationType() {
        return locationType;
    }

    // Abstract method to apply stats based on location and action
    public abstract void applyStats(Tamagotchi tamagotchi, String action);

    
}

// Lobby class as a top-level class
class Lobby extends Location {
    public Lobby() {
        super(Type.LOBBY);
    }

    @Override
    public void applyStats(Tamagotchi tamagotchi, String action) {
        switch (action) {
        case "play":
                tamagotchi.increaseHappiness(10);
                tamagotchi.decreaseEnergy(15);
                tamagotchi.increaseHunger(5);
                if(tamagotchi.getHappiness() < 10 && tamagotchi.getHunger() < 5 && tamagotchi.getEnergy() < 15 ){
                System.out.println("You played with your Tamagotchi in the lobby.");
                }
                break;
            case "train":
                System.out.println("Training is not allowed in the lobby.");
                break;
            case "rest":
                tamagotchi.increaseEnergy(40);
                if(tamagotchi.getEnergy() < 100 ){
                    System.out.println("Resting in the lobby gives an extra energy boost!");
                }
                break;
            case "feed":
                tamagotchi.decreaseHunger(15);
                tamagotchi.decreasePhysique(10);
                if(tamagotchi.getPhysique() > 0 && tamagotchi.getHunger() > 0 ){
                    System.out.println("You fed your Tamagotchi in the lobby.");
                }
                break;
            default:
                System.out.println("Unknown action.");
                break;
        }
    }
}


class Kitchen extends Location {
    public Kitchen() {
        super(Type.KITCHEN);
    }

    @Override
    public void applyStats(Tamagotchi tamagotchi, String action) {
        switch (action) {
            case "feed":
                tamagotchi.decreaseHunger(25);
                tamagotchi.decreasePhysique(5);
                if(tamagotchi.getPhysique() > 0 && tamagotchi.getHunger() < 100){
                    System.out.println("Eating food from the fridge reduces extra hunger.");
                }
                break;
            case "play":
                System.out.println("Playing is not allowed in the kitchen.");
                break;
            case "rest":
                tamagotchi.increaseEnergy(10);
                if(tamagotchi.getEnergy() < 100 ){
                    System.out.println("Your Tamagotchi rested in the kitchen.");
                }
                break;
            case "train":
                tamagotchi.increasePhysique(10);
                tamagotchi.decreaseEnergy(15);
                if(tamagotchi.getPhysique() < 100 && tamagotchi.getEnergy() > 0 ){
                    System.out.println("Your Tamagotchi trained in the kitchen.");
                }
                break;
            default:
                System.out.println("Unknown action.");
                break;
        }
    }
    
}

class Playground extends Location {
    public Playground() {
        super(Type.PLAYGROUND);
    }

    @Override
    public void applyStats(Tamagotchi tamagotchi, String action) {
        switch (action) {
            case "play":
                tamagotchi.increaseHappiness(20);
                tamagotchi.decreaseEnergy(10);
                tamagotchi.increaseHunger(5);
                if(tamagotchi.getHappiness() < 100 && tamagotchi.getHunger() < 100 && tamagotchi.getEnergy() > 0 ){
                    System.out.println("Playing in the playground boosts happiness!");
                }
                break;
            case "train":
                System.out.println("Training is not allowed in the playground.");
                break;
            case "feed":
                tamagotchi.decreaseHunger(15);
                tamagotchi.decreasePhysique(5);
                if(tamagotchi.getPhysique() > 0 && tamagotchi.getHunger() > 0){
                    System.out.println("You fed your Tamagotchi in the playground.");
                }
                break;
            case "rest":
                tamagotchi.increaseEnergy(10);
                if(tamagotchi.getEnergy() < 100 ){
                    System.out.println("Your Tamagotchi rested in the playground.");
                }
                break;
            default:
                System.out.println("Unknown action.");
                break;
        }
    }
}

class Gym extends Location {
    public Gym() {
        super(Type.GYM);
    }

    @Override
    public void applyStats(Tamagotchi tamagotchi, String action) {
        switch (action) {
            case "train":
                tamagotchi.increasePhysique(20);
                tamagotchi.decreaseEnergy(20);
                if(tamagotchi.getPhysique() < 100 && tamagotchi.getEnergy() > 0 ){
                    System.out.println("Training in the gym gives a bonus to physique!");
                }
                break;
            case "play":
                tamagotchi.increaseHappiness(10);
                tamagotchi.decreaseEnergy(15);
                tamagotchi.increaseHunger(5);
                if(tamagotchi.getHappiness() < 100 && tamagotchi.getHunger() < 100 && tamagotchi.getEnergy() > 0 ){
                    System.out.println("You played with your Tamagotchi in the gym.");
                }
                break;
            case "rest":
                tamagotchi.increaseEnergy(10);
                if(tamagotchi.getEnergy() < 100 ){
                    System.out.println("Your Tamagotchi rested in the gym.");
                }
                break;
            case "feed":
                System.out.println("Eating is not allowed in the gym.");
                break;
            default:
                System.out.println("Unknown action.");
                break;
        }
    }
}
