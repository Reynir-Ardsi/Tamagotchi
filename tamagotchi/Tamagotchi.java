package tamagotchi;
import java.util.Scanner;

public class Tamagotchi{
    private static Tamagotchi instance;
    private int hunger;
    private int happiness;
    private int energy;
    private int physique;
    private Location location;

    private Tamagotchi(int hunger, int happiness, int energy, int physique) {
        this.hunger = hunger;
        this.happiness = happiness;
        this.energy = energy;
        this.physique = physique;
        this.location = new Lobby(); // Default starting location
    }
    // Getter for Hunger
    public int getHunger() {
        return hunger;
    }

    // Getter for Happiness
    public int getHappiness() {
        return happiness;
    }

    // Getter for Energy
    public int getEnergy() {
        return energy;
    }

    // Getter for Physique
    public int getPhysique() {
        return physique;
    }

    //Singleton Design
    //checks if an instance of Tamagotchi is already existing
    public static Tamagotchi getInstance() {
        if (instance == null) {
            instance = new Tamagotchi(70, 30, 30, 30);
        }
        return instance;
    }

    public void feed() {
        location.applyStats(this, "feed");
    }

    public void play() {
        location.applyStats(this, "play");
    }

    public void rest() {
        location.applyStats(this, "rest");
    }

    public void train() {
        location.applyStats(this, "train");
    }

    public void checkStatus() {
        System.out.println("Current Location: " + location.getLocationType());
        System.out.println("Hunger: " + hunger);
        System.out.println("Happiness: " + happiness);
        System.out.println("Energy: " + energy);
        System.out.println("Physique: " + physique);
    }

    public void travelTo(Location.Type newLocationType) {
        if (location.getLocationType() == newLocationType) {
            System.out.println("You are already at this location.");
        } else {
            location = LocationFactory.createLocation(newLocationType);
            System.out.println("You went to the " + newLocationType + ".");
        }
    }
    

    // Helper methods for increasing/decreasing attributes with boundaries
    //DRY (Don't Repeat Yourself) Pattern
    public void increaseHappiness(int amount) {
        if (happiness == 100) {
            System.out.println("Your Tamagotchi is energetic ");
        }else{
            happiness = Math.min(happiness + amount, 100);
        }
    }
    
    public void decreaseHappiness(int amount) {
        if (happiness == 0) {
            System.out.println("Your Tamagotchi is not in the mood");
        }else{
            happiness = Math.max(happiness - amount, 0);
        }
    }
    
    public void increaseEnergy(int amount) {
        if (energy == 100) {
            System.out.println("Your Tamagotchi is energetic");
        }else{
            energy = Math.min(energy + amount, 100);
        }
    }
    
    public void decreaseEnergy(int amount) {
        if (energy == 0) {
            System.out.println("Your Tamagotchi is exhausted");
        }else{
            energy = Math.max(energy - amount, 0);
        }
    }
    
    public void decreaseHunger(int amount) {
        if (hunger == 0) {
            System.out.println("Your Tamagotchi is full");
        }else{
            hunger = Math.max(hunger - amount, 0);
        }
    }
    
    public void increaseHunger(int amount) {
        if (hunger == 100) {
            System.out.println("Your Tamagotchi is starving");
        }else{
            hunger = Math.min(hunger - amount, 100);
        }
    }
    
    public void increasePhysique(int amount) {
        if (physique == 100) {
            System.out.println("Your Tamagotchi is already buffed");
        }else{
            physique = Math.min(physique + amount, 100);
        }
    }
    
    public void decreasePhysique(int amount) {
        if (physique == 0) {
            System.out.println("Your Tamagotchi needs to exercise");
        }else{
            physique = Math.max(physique - amount, 0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tamagotchi tamagotchi = getInstance();
    
        while (true) {
            System.out.println("\n1. Feed\n2. Play\n3. Rest\n4. Train\n5. Status\n6. Travel\n7. Exit");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine().toLowerCase();
    
            switch (input) {
                case "feed":
                    tamagotchi.feed();
                    break;
                case "play":
                    tamagotchi.play();
                    break;
                case "rest":
                    tamagotchi.rest();
                    break;
                case "train":
                    tamagotchi.train();
                    break;
                case "status":
                    tamagotchi.checkStatus();
                    break;
                case "travel": {
                    Location.Type currentLocation = tamagotchi.location.getLocationType();
                    System.out.println("Where would you like to go?");
    
                    // Display available locations except the current one
                    if (currentLocation != Location.Type.LOBBY) System.out.println("LOBBY");
                    if (currentLocation != Location.Type.KITCHEN) System.out.println("KITCHEN");
                    if (currentLocation != Location.Type.PLAYGROUND) System.out.println("PLAYGROUND");
                    if (currentLocation != Location.Type.GYM) System.out.println("GYM");
                    System.out.print("Input: ");
                    String locationInput = scanner.nextLine().toUpperCase();
                    switch (locationInput) {
                        case "LOBBY":
                            if (currentLocation == Location.Type.LOBBY) {
                                System.out.println("You are already in the LOBBY.");
                            } else {
                                tamagotchi.travelTo(Location.Type.LOBBY);
                            }
                            break;
                        case "KITCHEN":
                            if (currentLocation == Location.Type.KITCHEN) {
                                System.out.println("You are already in the KITCHEN.");
                            } else {
                                tamagotchi.travelTo(Location.Type.KITCHEN);
                            }
                            break;
                        case "PLAYGROUND":
                            if (currentLocation == Location.Type.PLAYGROUND) {
                                System.out.println("You are already in the PLAYGROUND.");
                            } else {
                                tamagotchi.travelTo(Location.Type.PLAYGROUND);
                            }
                            break;
                        case "GYM":
                            if (currentLocation == Location.Type.GYM) {
                                System.out.println("You are already in the GYM.");
                            } else {
                                tamagotchi.travelTo(Location.Type.GYM);
                            }
                            break;
                        default:
                            System.out.println("Invalid location choice.");
                            break;
                    }
                    break;
                }
                case "exit":
                    System.out.println("Your Tamagotchi waved goodbye!");
                    scanner.close();
                    return; // Exit program
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }
}
